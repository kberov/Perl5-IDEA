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

package com.perl5.lang.perl.idea.run.debugger;

import com.intellij.execution.ExecutionException;

/**
 * Created by hurricup on 18.05.2016.
 */
public interface PerlDebugOptions
{
	String ROLE_SERVER = "server";
	String ROLE_CLIENT = "client";

	String getDebugHost();

	int getDebugPort() throws ExecutionException;

	String getRemoteProjectRoot();

	String getStartMode();

	String getScriptCharset();

	String getPerlRole();
}
