/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

import org.apache.commons.bcel6.Repository;
import org.apache.commons.bcel6.classfile.ClassParser;
import org.apache.commons.bcel6.classfile.Field;
import org.apache.commons.bcel6.classfile.JavaClass;
import org.apache.commons.bcel6.classfile.Method;
import org.apache.commons.bcel6.generic.ClassGen;
import org.apache.commons.bcel6.generic.FieldGen;
import org.apache.commons.bcel6.generic.MethodGen;

/**
 * Test BCEL if an input file is identical to the outfile generated
 * with BCEL. Of course there may some small differences, e.g., because
 * BCEL generates local variable tables by default.
 *
 * Try to:
 * <pre>
 * % java id <someclass>
 * % java listclass -code <someclass> &gt; foo
 * % java listclass -code <someclass>.clazz &gt; bar
 * % diff foo bar | more
 * <pre>
 *
 * @version $Id$
 */
public class id {

    public static void main(String[] argv) throws Exception {
        JavaClass clazz;

        if ((clazz = Repository.lookupClass(argv[0])) == null) {
            clazz = new ClassParser(argv[0]).parse(); // May throw IOException
        }

        ClassGen cg = new ClassGen(clazz);

        for (Method method : clazz.getMethods()) {
            MethodGen mg = new MethodGen(method, cg.getClassName(), cg.getConstantPool());
            cg.replaceMethod(method, mg.getMethod());
        }

        for (Field field : clazz.getFields()) {
            FieldGen fg = new FieldGen(field, cg.getConstantPool());
            cg.replaceField(field, fg.getField());
        }

        cg.getJavaClass().dump(clazz.getClassName() + ".clazz");
    }
}
