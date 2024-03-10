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

public class BPM_show_in_Processing
extends TranslatorBlock {
    public BPM_show_in_Processing(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
        String string3 = translatorBlock.toCode();
        this.translator.addDefinitionCommand("/*\n Tutorial\n https://pulsesensor.com/pages/getting-advanced \n https://github.com/WorldFamousElectronics/PulseSensor_Amped_Processing_Visualizer  \n */ \n #define USE_ARDUINO_INTERRUPTS false \n #include <PulseSensorPlayground.h>\n ");
        this.translator.addDefinitionCommand("const int OUTPUT_TYPE = SERIAL_PLOTTER; \n const int PULSE_INPUT = " + string + "; \n const int PULSE_BLINK = " + string2 + "; \n const int PULSE_FADE = " + string3 + "; \n const int THRESHOLD = 550; \n byte samplesUntilReport; \n const byte SAMPLES_PER_SERIAL_SAMPLE = 10; \n PulseSensorPlayground pulseSensor; \n");
        this.translator.addSetupCommand("Serial.begin(115200); \n pulseSensor.analogInput(PULSE_INPUT); \n pulseSensor.blinkOnPulse(PULSE_BLINK); \n pulseSensor.fadeOnPulse(PULSE_FADE); \n pulseSensor.setSerial(Serial); \n pulseSensor.setOutputType(OUTPUT_TYPE); \n pulseSensor.setThreshold(THRESHOLD); \n samplesUntilReport = SAMPLES_PER_SERIAL_SAMPLE; \n if(!pulseSensor.begin()){ \n Serial.println(\"PulseSensor initialization failed\"); \n }");
        return this.codePrefix + "if(pulseSensor.sawNewSample()){ \n if(--samplesUntilReport == (byte) 0){ \n samplesUntilReport = SAMPLES_PER_SERIAL_SAMPLE; \n pulseSensor.outputSample(); \n if(pulseSensor.sawStartOfBeat()){ \n pulseSensor.outputBeat();\n }\n }\n }\n" + this.codeSuffix;
    }
}
