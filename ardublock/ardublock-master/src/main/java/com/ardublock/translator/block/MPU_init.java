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

public class MPU_init
extends TranslatorBlock {
    public MPU_init(Long l, Translator translator, String string, String string2, String string3) {
        super(l, translator, string, string2, string3);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        this.translator.addHeaderFile("MPU6050.h");
        this.translator.addHeaderFile("Wire.h");
        this.translator.addDefinitionCommand("MPU6050 mpu6050(Wire);\n");
        this.translator.addSetupCommand("Wire.begin();");
        this.translator.addSetupCommand("mpu6050.begin();");
        this.translator.addSetupCommand("mpu6050.calcGyroOffsets(true);");
        String string = "mpu6050.update();\n";
        return string;
    }
}
