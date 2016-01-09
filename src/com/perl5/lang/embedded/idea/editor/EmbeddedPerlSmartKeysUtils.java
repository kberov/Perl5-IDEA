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

package com.perl5.lang.embedded.idea.editor;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.perl5.lang.embedded.psi.EmbeddedPerlElementTypes;
import com.perl5.lang.perl.psi.utils.PerlPsiUtil;
import org.jetbrains.annotations.NotNull;

/**
 * Created by hurricup on 09.01.2016.
 */
public class EmbeddedPerlSmartKeysUtils implements EmbeddedPerlElementTypes
{
	public static boolean addCloseMarker(@NotNull final Editor editor, @NotNull PsiFile file, @NotNull String marker)
	{
		PsiElement element = file.findElementAt(editor.getCaretModel().getOffset() - 2);
		if (element != null && element.getNode().getElementType() == EMBED_MARKER_OPEN)
		{
			ASTNode nextSibling = PerlPsiUtil.getNextSignificantSibling(element.getNode());
			if (nextSibling == null || nextSibling.getElementType() != EMBED_MARKER_CLOSE)
			{
				EditorModificationUtil.insertStringAtCaret(editor, marker, false, false);
				return true;
			}
		}
		return false;
	}
}
