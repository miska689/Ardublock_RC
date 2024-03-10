/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.ardublock.translator.Translator
 *  com.ardublock.translator.block.TranslatorBlock
 *  com.ardublock.translator.block.exception.SocketNullException
 *  com.ardublock.translator.block.exception.SubroutineNotDeclaredException
 */
package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class PulseSensor_blink_LED
extends TranslatorBlock {
    public PulseSensor_blink_LED(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        this.translator.addDefinitionCommand("//Tutorial Webpage: https://pulsesensor.com/pages/getting-advanced \n");
        this.translator.addDefinitionCommand("#define USE_ARDUINO_INTERRUPTS true\n #include <PulseSensorPlayground.h>\n int Threshold = 550;");
        this.translator.addDefinitionCommand("PulseSensorPlayground pulseSensor" + string + ";");
        this.translator.addSetupCommand("pulseSensor" + string + ".analogInput(" + string + ");\n pulseSensor" + string + ".blinkOnPulse(" + string2 + ");\n pulseSensor" + string + ".setThreshold(Threshold);\n if(!pulseSensor" + string + ".begin()){\n Serial.println(\"Error. The pulseSensor object was not created!\");\n }");
        String string3 = "int myBPM" + string + " = pulseSensor" + string + ".getBeatsPerMinute();\n ";
        return this.codePrefix + string3 + this.codeSuffix + "delay(20);";
    }
}
