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

public class OLED_drawBitmaps_masterYoda
extends TranslatorBlock {
    public OLED_drawBitmaps_masterYoda(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        this.translator.addDefinitionCommand("const unsigned char masterYoda [] PROGMEM = {\n0x00, 0x03, 0xff, 0xf0, 0x00, 0x00, 0x03, 0xff, 0xf0, 0x00, 0xf0, 0x0f, 0xff, 0xfc, 0x18, 0xf8,\n0x0f, 0xff, 0xfc, 0x18, 0xf8, 0x1f, 0xfa, 0xfc, 0x38, 0xc7, 0xff, 0x18, 0x0c, 0xf8, 0xc7, 0xff,\n0x38, 0x0c, 0x78, 0xf8, 0x0f, 0xff, 0xff, 0x18, 0xf8, 0x0f, 0xff, 0xff, 0x18, 0x3e, 0x03, 0x01,\n0xf0, 0xe0, 0x3e, 0x03, 0x01, 0xf0, 0xe0, 0x0f, 0xfc, 0x46, 0x1c, 0x00, 0x07, 0xfc, 0xc6, 0x0c,\n0x00, 0x07, 0xfc, 0xe6, 0x0c, 0x00, 0x00, 0x0f, 0xff, 0xff, 0x00, 0x00, 0x0f, 0xff, 0xff, 0x00,\n0x00, 0x03, 0xff, 0xfc, 0x00, 0x00, 0x03, 0xff, 0xfc, 0x00, 0x01, 0x80, 0x07, 0xf0, 0x00, 0x01,\n0x80, 0x07, 0xf0, 0x00, 0x01, 0xc0, 0x07, 0xe0, 0x00, 0x01, 0xf3, 0xf8, 0x03, 0x00, 0x01, 0xf3,\n0xf8, 0x03, 0x00, 0x00, 0x73, 0xc0, 0x0f, 0x00, 0x00, 0x73, 0xc0, 0x0f, 0x00, 0x00, 0x00, 0x00,\n0x0f, 0x00, 0x00, 0x00, 0x00, 0x0f, 0x00, 0x00, 0x00, 0x46, 0x00, 0x00, 0x00, 0x00, 0xc6, 0x00,\n0x00, 0x00, 0x00, 0xc6, 0x00, 0x00, 0x00, 0x7f, 0x01, 0xfc, 0x00, 0x00, 0x7f, 0x01, 0xfc, 0x00};\n");
        String string3 = "";
        string3 = string3 + "oled.drawBitmap(" + string + ", " + string2 + ",masterYoda, 37, 32, WHITE);\n";
        string3 = string3 + "oled.display();\n";
        return string3;
    }
}