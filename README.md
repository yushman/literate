# IntelliJ Transliteration Plugin

[![Version](https://img.shields.io/jetbrains/plugin/v/27975.svg)](https://plugins.jetbrains.com/plugin/27975)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/27975.svg)](https://plugins.jetbrains.com/plugin/27975)

A plugin for IntelliJ-based IDEs that transliterates selected text between Cyrillic and Latin keyboard layouts with a single shortcut.

## Features

- Converts "Ghbdtn" to "Привет" and vice versa
- Smart automatic direction detection (Cyrillic ↔ Latin)
- Preserves non-alphabetic characters
- Works in all text editors within IntelliJ platform
- Configurable keyboard shortcut

## Installation

### From JetBrains Marketplace (recommended)
1. Go to `Settings/Preferences > Plugins > Marketplace`
2. Search for "LiterateIt"
3. Click `Install` and restart your IDE

### Manual Installation
1. Download the latest `.zip` from [Releases](https://github.com/yushman/literate/releases)
2. Go to `Settings/Preferences > Plugins > ⚙️ > Install Plugin from Disk...`
3. Select the downloaded `.zip` file
4. Restart your IDE

## Usage

1. Select text in your editor
2. Press `Ctrl+Shift+T` (default shortcut)
3. The selected text will be automatically transliterated

## Supported Layouts

- Russian ↔ QWERTY
- Other Cyrillic layouts (partial support)

## Configuration

To change the keyboard shortcut:
1. Go to `Settings/Preferences > Keymap`
2. Search for "Transliterate Text"
3. Right-click to add your preferred shortcut

## Build from Source

### Requirements
- JDK 21+
- IntelliJ IDEA 2024.1+
- Gradle

### Steps
```bash
git clone https://github.com/yourusername/intellij-transliteration.git
cd intellij-transliteration
./gradlew buildPlugin