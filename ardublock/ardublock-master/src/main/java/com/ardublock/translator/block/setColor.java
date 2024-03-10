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

public class setColor
extends TranslatorBlock {
    public setColor(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
        String r = tb.toCode();
        tb = this.getRequiredTranslatorBlockAtSocket(1);
        String g = tb.toCode();
        tb = this.getRequiredTranslatorBlockAtSocket(2);
        String b = tb.toCode();
        String code = "sword.setColor(" + r + ", " + g + ", " + b + ");";
        return String.valueOf(this.codePrefix) + code + this.codeSuffix;
    }
}
