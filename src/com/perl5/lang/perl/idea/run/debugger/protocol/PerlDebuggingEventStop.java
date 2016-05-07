/*
 * Copyright 2016 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.idea.run.debugger.protocol;

import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.frame.XSuspendContext;
import com.perl5.lang.perl.idea.run.debugger.PerlSuspendContext;

/**
 * Created by hurricup on 05.05.2016.
 */
public class PerlDebuggingEventStop implements PerlDebuggingEvent
{
	private PerlDebuggingStackFrame[] myFrames;

	public void setFrames(PerlDebuggingStackFrame[] frames)
	{
		myFrames = frames;
	}

	public XSuspendContext getSuspendContext()
	{
		return new PerlSuspendContext(myFrames);
	}

	@Override
	public void doWork(XDebugSession session)
	{
		session.positionReached(getSuspendContext());
	}
}