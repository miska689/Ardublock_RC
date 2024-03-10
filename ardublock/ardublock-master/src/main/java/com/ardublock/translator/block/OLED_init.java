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

public class OLED_init
extends TranslatorBlock {
    public OLED_init(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        String string2 = this.getRequiredTranslatorBlockAtSocket(1).toCode();
        String string3 = this.getRequiredTranslatorBlockAtSocket(2).toCode();
        this.translator.addHeaderFile("Wire.h");
        this.translator.addHeaderFile("Adafruit_GFX.h");
        this.translator.addHeaderFile("Adafruit_SSD1306.h");
        this.translator.addDefinitionCommand("#define SCREEN_WIDTH\t" + string + " \n#define SCREEN_HEIGHT\t" + string2 + "\n#define SCREEN_ADDRESS\t0x" + string3 + "\n Adafruit_SSD1306 oled(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, -1);");
        this.translator.addSetupCommand("oled.begin(SSD1306_SWITCHCAPVCC, SCREEN_ADDRESS); \noled.clearDisplay(); \ndelay(100); \noled.display(); ");
        return this.codePrefix + this.codeSuffix;
    }
}
