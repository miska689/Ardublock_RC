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

public class OLED_drawBitmaps_lock
extends TranslatorBlock {
    public OLED_drawBitmaps_lock(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        this.translator.addDefinitionCommand("const unsigned char lock [] PROGMEM = {\n0x00, 0x7c, 0x00, 0x01, 0xff, 0x00, 0x03, 0xff, 0x80, 0x07, 0xc7, 0xc0, 0x0f, 0x83, 0xe0, 0x0f,\n0x01, 0xe0, 0x0e, 0x00, 0xe0, 0x0e, 0x00, 0xe0, 0x0e, 0x00, 0xe0, 0x0e, 0x00, 0xe0, 0x0e, 0x00,\n0xe0, 0x0e, 0x00, 0xe0, 0x0e, 0x00, 0xe0, 0x0e, 0x00, 0xe0, 0x1f, 0xff, 0xf0, 0x3f, 0xff, 0xf8,\n0x3f, 0xff, 0xf8, 0x3f, 0xff, 0xf8, 0x3f, 0xef, 0xf8, 0x3f, 0xc7, 0xf8, 0x3f, 0x83, 0xf8, 0x3f,\n0xc7, 0xf8, 0x3f, 0xef, 0xf8, 0x3f, 0xc7, 0xf8, 0x3f, 0xc7, 0xf8, 0x3f, 0x83, 0xf8, 0x3f, 0xc7,\n0xf8, 0x3f, 0xff, 0xf8, 0x3f, 0xff, 0xf8, 0x1f, 0xff, 0xf0};\n");
        String string3 = "";
        string3 = string3 + "oled.drawBitmap(" + string + ", " + string2 + ",lock, 23, 30, WHITE);\n";
        string3 = string3 + "oled.display();\n";
        return string3;
    }
}
