# 24 Card Game 🃏

Welcome to 24 Card Game! This is an interactive math game that was built using Java, JavaFX, and the OpenAI API.

## Table of Contents
- [Introduction & Rules](#introduction-&-rules)
- [Installation](#installation)
- [Usage](#usage)
- [API Reference](#api-reference)
- [Tech](#tech)

## Introduction & Rules
The game begins by drawing 4 cards from a standard 52-card deck. Your goal is to create a mathematical expression that evaluates to 24 using each card’s numerical value exactly once.  

### Rules:
- You **must** use each card’s value exactly once—no extra numbers allowed.  
- You may only use basic arithmetic operations:
  - Addition (+)
  - Subtraction (-)
  - Multiplication (*)
  - Division (/)
  - Parentheses may also be used for grouping.  
- Face cards are assigned the following values:
  - Ace = 1  
  - Jack = 11  
  - Queen = 12  
  - King = 13
- Do **not** use decimal values or special characters (e.g., !, @, #)
- You have a maximum of **3 hints**, so use them wisely! (Hints provide possible operations or number pairings to help you.)  
- Most importantly: **have fun!** 😊

## Installation
As of now, the Card 24 Game must be ran locally.
### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Apache Maven
- An IDE such as IntelliJ IDEA

### Steps

1. **Clone the repository:**

    ```sh
    git clone https://github.com/WJijon223/CardGame-24.git
    cd CardGame-24
    ```

2. **Build the project using Maven:**

    ```sh
    mvn clean install
    ```

3. **Run the application:**

    ```sh
    mvn javafx:run
    ```

### Environment Variables

Make sure to set the `OPENAI_API_KEY` environment variable with your OpenAI API key:

- On Windows:

    ```sh
    setx OPENAI_API_KEY "your_openai_api_key"
    ```

- On macOS/Linux:

    ```sh
    export OPENAI_API_KEY="your_openai_api_key"
    ```

### Running the Application in IntelliJ IDEA

1. Open IntelliJ IDEA and select `File -> Open` and choose the project directory.
2. Wait for IntelliJ to index the project and download dependencies.
3. Set the `OPENAI_API_KEY` environment variable in the run configuration:
    - Go to `Run -> Edit Configurations`.
    - Select the application configuration.
    - Add `OPENAI_API_KEY` in the `Environment variables` field.
4. Run the `MainApplication` class.

Your application should now be up and running.

## Usage  
- Click the **Refresh** button to start a new game.  
- Enter your mathematical expression in the text field at the bottom of the window.  
- Click the **Verify** button to check your answer.  
- If correct, a confirmation message will appear, and the game will reset automatically after 5 seconds.  
- Click the **Hint** button to use a hint.  
- Click the **Refresh** button to start a new game with a different set of cards.  

## API Reference

### JavaFX API

The **JavaFX API** provides classes for creating rich user interfaces in Java. Key resources include:

- [Scene Docs](https://openjfx.io/javadoc/16/javafx.graphics/javafx/scene/Scene.html)
- [Button Docs](https://openjfx.io/javadoc/16/javafx.controls/javafx/scene/control/Button.html)
- [Stage Docs](https://openjfx.io/javadoc/16/javafx.graphics/javafx/stage/Stage.html)

For complete documentation, visit [OpenJFX Documentation](https://openjfx.io/javadoc/23/).

---

### OpenAI API

The **OpenAI API** allows you to interact with AI models for tasks like text generation and image creation. Key endpoints include:

- [Completions API](https://platform.openai.com/docs/guides/completions) – for generating text completions.
- [Images API](https://platform.openai.com/docs/guides/images) – for generating images from text prompts.

For more details, visit the [OpenAI API Documentation](https://platform.openai.com/docs/).

## Tech Stack
**Java, JavaFX**
