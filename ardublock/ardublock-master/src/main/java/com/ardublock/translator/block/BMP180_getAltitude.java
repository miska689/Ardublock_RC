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

public class BMP180_getAltitude
extends TranslatorBlock {
    public BMP180_getAltitude(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        this.translator.addHeaderFile("Wire.h");
        this.translator.addHeaderFile("Adafruit_BMP085.h");
        this.translator.addDefinitionCommand("Adafruit_BMP085 bmp;\n");
        this.translator.addSetupCommand("bmp.begin();");
        String string = "bmp.readAltitude()";
        return this.codePrefix + string + this.codeSuffix;
    }
}
