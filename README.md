# IntelliJ Transliteration Plugin

[![Build Status](https://img.shields.io/github/actions/workflow/status/yourusername/intellij-transliteration/build.yml)](https://github.com/yourusername/intellij-transliteration/actions)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

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
2. Search for "Transliteration"
3. Click `Install` and restart your IDE

### Manual Installation
1. Download the latest `.jar` from [Releases](https://github.com/yourusername/intellij-transliteration/releases)
2. Go to `Settings/Preferences > Plugins > ⚙️ > Install Plugin from Disk...`
3. Select the downloaded `.jar` file
4. Restart your IDE

## Usage

1. Select text in your editor
2. Press `Ctrl+Alt+T` (default shortcut)
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
- JDK 17+
- IntelliJ IDEA 2023.2+
- Gradle

### Steps
```bash
git clone https://github.com/yourusername/intellij-transliteration.git
cd intellij-transliteration
./gradlew build