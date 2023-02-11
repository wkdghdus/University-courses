words = ["Today", "is", "Friday", "tomorrow", "is", "Saturday"]
for i in range(len(words)):
    print(range(len(words)))
    if i < len(words):
        word = words[i]
        if len(word) < 6:
            words.pop(i)
    print(i)