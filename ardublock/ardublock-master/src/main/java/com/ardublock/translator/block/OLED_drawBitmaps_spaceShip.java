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

public class OLED_drawBitmaps_spaceShip
extends TranslatorBlock {
    public OLED_drawBitmaps_spaceShip(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        this.translator.addDefinitionCommand("const unsigned char spaceShip [] PROGMEM = {\n0x03, 0x00, 0x00, 0x07, 0x80, 0x00, 0x3f, 0xc0, 0x00, 0x7f, 0xe0, 0x00, 0xff, 0xf0, 0x00, 0xff,\n0xf8, 0x00, 0x07, 0xfc, 0x00, 0x03, 0xfe, 0x00, 0x07, 0xff, 0x00, 0x0f, 0xff, 0xc0, 0x0f, 0x3f,\n0xf8, 0x0f, 0x1f, 0xff, 0x0f, 0x1f, 0xff, 0x0f, 0x3f, 0xf8, 0x0f, 0xff, 0xc0, 0x07, 0xff, 0x00,\n0x03, 0xfe, 0x00, 0x07, 0xfc, 0x00, 0xff, 0xf8, 0x00, 0xff, 0xf0, 0x00, 0x7f, 0xe0, 0x00, 0x3f,\n0xc0, 0x00, 0x07, 0x80, 0x00, 0x03, 0x00, 0x00};\n");
        String string3 = "";
        string3 = string3 + "oled.drawBitmap(" + string + ", " + string2 + ",spaceShip, 24, 24, WHITE);\n";
        string3 = string3 + "oled.display();\n";
        return string3;
    }
}
