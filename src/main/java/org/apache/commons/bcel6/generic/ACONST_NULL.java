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
 * ACONST_NULL - Push null reference
 * <PRE>Stack: ... -&gt; ..., null</PRE>
 *
 * @version $Id$
 */
public class ACONST_NULL extends Instruction implements PushInstruction, TypedInstruction {

    private static final long serialVersionUID = -4127036801984829715L;


    /** 
     * Push null reference
     */
    public ACONST_NULL() {
        super(org.apache.commons.bcel6.Constants.ACONST_NULL, (short) 1);
    }


    /** @return Type.NULL
     */
    public Type getType( ConstantPoolGen cp ) {
        return Type.NULL;
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
        v.visitStackProducer(this);
        v.visitPushInstruction(this);
        v.visitTypedInstruction(this);
        v.visitACONST_NULL(this);
    }
}
