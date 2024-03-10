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

public class OLED_print
extends TranslatorBlock {
    public OLED_print(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String string = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        String string2 = translatorBlock.toCode();
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
        String string3 = translatorBlock.toCode();
        String string4 = "";
        string4 = string4 + "oled.setTextSize(" + string3 + ");\n";
        string4 = string4 + "oled.setTextColor(SSD1306_WHITE);\n";
        string4 = string4 + "oled.setCursor(" + string + ", " + string2 + ");\n";
        string4 = string4 + "oled.cp437(true);\n";
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(3, "oled.print( ", " );\n");
        string4 = string4 + translatorBlock.toCode();
        string4 = string4 + "oled.display();\n";
        return string4;
    }
}
