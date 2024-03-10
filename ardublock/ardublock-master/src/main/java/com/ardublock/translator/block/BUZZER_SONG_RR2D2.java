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

public class BUZZER_SONG_RR2D2
extends TranslatorBlock {
    public BUZZER_SONG_RR2D2(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String string = this.getRequiredTranslatorBlockAtSocket(0).toCode();
        String string2 = this.getRequiredTranslatorBlockAtSocket(1).toCode();
        this.translator.addHeaderFile("ROBOCODE_R2D2.h");
        this.translator.addDefinitionCommand("#define buzzerPin\t" + string + " \n#define ledPin\t" + string2 + "\n");
        return this.codePrefix + "RandomSoundR2D2(buzzerPin, ledPin);" + this.codeSuffix;
    }
}
