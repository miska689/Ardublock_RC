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

public class OLED_drawLine
extends TranslatorBlock {
    public OLED_drawLine(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        String string2 = this.getRequiredTranslatorBlockAtSocket(1).toCode();
        String string3 = this.getRequiredTranslatorBlockAtSocket(2).toCode();
        String string4 = this.getRequiredTranslatorBlockAtSocket(3).toCode();
        return this.codePrefix + "\noled.drawLine(" + string + ", " + string2 + ", " + string3 + ", " + string4 + ", SSD1306_WHITE); \noled.display(); \n" + this.codeSuffix;
    }
}
