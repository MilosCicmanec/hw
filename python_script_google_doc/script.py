import keyboard
import time
import random
import sys


def type_via_unicode(char):
    char_hex = hex(ord(char))[2:]
    keyboard.send("ctrl+shift+u")
    time.sleep(0.02)
    for hex_digit in char_hex:
        keyboard.send(hex_digit)
        time.sleep(0.01)
    keyboard.send("enter")


def type_character(char):
    if char == "\n":
        keyboard.send("enter")
    elif char == "\t":
        keyboard.send("tab")
    elif ord(char) > 127:
        type_via_unicode(char)
    else:
        try:
            keyboard.write(char)
        except (StopIteration, ValueError):
            type_via_unicode(char)


def simulate_typing(file_path):
    try:
        with open(file_path, "r", encoding="utf-8") as file:
            text_to_type = file.read()
    except FileNotFoundError:
        print(f"Error: The file '{file_path}' was not found.")
        sys.exit()

    print("Script is running! You have 5 seconds to click into your document...")
    time.sleep(5)

    keyboard.send("shift")
    time.sleep(0.5)
    keyboard.release("ctrl")
    keyboard.release("shift")
    keyboard.release("alt")

    i = 0
    chars_since_space = 0
    chars_since_sentence_start = 0
    sentences_typed = 0
    sentences_before_pause = random.randint(1, 3)

    while i < len(text_to_type):
        # 1. EXPLICIT PAUSE TAG
        if text_to_type[i : i + 7] == "[pause]":
            time.sleep(random.uniform(2.5, 11.0))
            i += 7
            chars_since_space = 0
            continue

        # 2. ENTIRE SENTENCE REWRITE TAG
        if text_to_type[i : i + 9] == "[rewrite]":
            time.sleep(random.uniform(1.0, 2.5))  # Realize the sentence is bad
            for _ in range(chars_since_sentence_start):
                keyboard.send("backspace")
                time.sleep(
                    random.uniform(0.03, 0.08)
                )  # Delete the whole sentence quickly

            time.sleep(random.uniform(0.8, 8.0))  # Think about how to rewrite it

            chars_since_sentence_start = 0
            chars_since_space = 0
            i += 9
            continue

        # 3. SMALL WORD MISTAKES (The // syntax)
        if text_to_type[i : i + 2] == "//":
            end_idx = i + 2
            correction = ""
            while end_idx < len(text_to_type) and text_to_type[end_idx] not in [
                " ",
                "\n",
                "\t",
            ]:
                correction += text_to_type[end_idx]
                end_idx += 1

            time.sleep(random.uniform(0.6, 1.5))
            for _ in range(chars_since_space):
                keyboard.send("backspace")
                time.sleep(random.uniform(0.05, 0.12))

            time.sleep(random.uniform(0.3, 0.7))
            for c in correction:
                type_character(c)
                time.sleep(random.uniform(0.15, 0.35))  # Match new slower speed
                chars_since_sentence_start += 1

            chars_since_space = len(correction)
            i = end_idx
            continue

        # 4. NORMAL TYPING
        char = text_to_type[i]

        # Track word length
        if char in [" ", "\n", "\t"]:
            chars_since_space = 0
        else:
            chars_since_space += 1

        # Track sentence length (resets on punctuation)
        if char in [".", "?", "!", "\n"]:
            chars_since_sentence_start = 0
        else:
            chars_since_sentence_start += 1

        type_character(char)

        # 5. PACING & HESITATIONS
        if char in [".", "?", "!"]:
            sentences_typed += 1
            if sentences_typed >= sentences_before_pause:
                time.sleep(random.uniform(3.0, 7.5))
                sentences_typed = 0
                sentences_before_pause = random.randint(1, 3)
            else:
                time.sleep(random.uniform(0.5, 1.5))

        # MID-WORD FIX: Only hesitate if the character is a space (between words)
        elif char == " " and random.random() < 0.03:
            time.sleep(random.uniform(1.2, 20.0))

        else:
            # Slower ~40 WPM pace
            time.sleep(random.uniform(0.15, 0.35))

        i += 1

    print("\nTyping successfully completed!")


if __name__ == "__main__":
    simulate_typing("test.txt")
