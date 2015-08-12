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
package org.apache.commons.bcel6.generic;

/** 
 * FLOAD - Load float from local variable
 * <PRE>Stack ... -&gt; ..., result</PRE>
 *
 * @version $Id$
 */
public class FLOAD extends LoadInstruction {

    private static final long serialVersionUID = 7970650436462434345L;


    /**
     * Empty constructor needed for the Class.newInstance() statement in
     * Instruction.readInstruction(). Not to be used otherwise.
     */
    FLOAD() {
        super(org.apache.commons.bcel6.Constants.FLOAD, org.apache.commons.bcel6.Constants.FLOAD_0);
    }


    /** Load float from local variable
     * @param n index of local variable
     */
    public FLOAD(int n) {
        super(org.apache.commons.bcel6.Constants.FLOAD, org.apache.commons.bcel6.Constants.FLOAD_0, n);
    }


    /**
     * Call corresponding visitor method(s). The order is:
     * Call visitor methods of implemented interfaces first, then
     * call methods according to the class hierarchy in descending order,
     * i.e., the most specific visitXXX() call comes last.
     *
     * @param v Visitor object
     */
    @Override
    public void accept( Visitor v ) {
        super.accept(v);
        v.visitFLOAD(this);
    }
}
