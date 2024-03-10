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

public class my_str
extends TranslatorBlock {
    public my_str(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.translator.getNumberVariable(this.label);
        if (string == null) {
            string = this.translator.buildVariableName(this.label);
            this.translator.addNumberVariable(this.label, string);
            this.translator.addDefinitionCommand("char " + string + "[64] = \"\";");
        }
        return this.codePrefix + string + this.codeSuffix;
    }
}
