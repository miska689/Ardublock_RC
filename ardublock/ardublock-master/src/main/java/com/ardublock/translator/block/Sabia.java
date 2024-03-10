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

public class Sabia
extends TranslatorBlock {
    public Sabia(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
        String red = tb.toCode();
        tb = this.getRequiredTranslatorBlockAtSocket(1);
        String green = tb.toCode();
        tb = this.getRequiredTranslatorBlockAtSocket(2);
        String blue = tb.toCode();
        tb = this.getRequiredTranslatorBlockAtSocket(3);
        String pcm = tb.toCode();
        tb = this.getRequiredTranslatorBlockAtSocket(4);
        String button = tb.toCode();
        String code = "";
        this.translator.addHeaderFile("SS_Sword.h");
        this.translator.addDefinitionCommand("Sabia sword(" + red + ", " + green + ", " + blue + ", " + pcm + ", " + button + ");");
        this.translator.addSetupCommand("sword.init();");
        return "";
    }
}
