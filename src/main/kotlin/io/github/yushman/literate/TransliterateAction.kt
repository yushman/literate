package io.github.yushman.literate

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class TransliterateAction : AnAction() {
    // Mapping for Russian keyboard layout to English
    private companion object {
        private const val RUSSIAN_LAYOUT = "йцукенгшщзхъфывапролджэячсмитьбю.ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ,"
        private const val ENGLISH_LAYOUT = "qwertyuiop[]asdfghjkl;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?"
    }

    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)
        val selectionModel = editor.selectionModel

        if (!selectionModel.hasSelection()) return

        val selectedText = selectionModel.selectedText ?: return
        val transformedText = transliterate(selectedText)

        // Replace the selected text with the transformed version
        WriteCommandAction.runWriteCommandAction(editor.project) {
            editor.document.replaceString(
                selectionModel.selectionStart,
                selectionModel.selectionEnd,
                transformedText
            )
        }
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    private fun transliterate(text: String): String {
        // Determine direction (Cyrillic -> Latin or Latin -> Cyrillic)
        val probablyRussian = text.any { c ->
            RUSSIAN_LAYOUT.contains(c) || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC
        }

        return text.map { c ->
            when {
                probablyRussian -> {
                    val index = RUSSIAN_LAYOUT.indexOf(c)
                    if (index != -1) ENGLISH_LAYOUT[index] else c
                }

                else -> {
                    val index = ENGLISH_LAYOUT.indexOf(c)
                    if (index != -1) RUSSIAN_LAYOUT[index] else c
                }
            }
        }.joinToString("")
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabledAndVisible = editor != null && editor.selectionModel.hasSelection()
    }
}