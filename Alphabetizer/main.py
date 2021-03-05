import sys
import os.path
from os import path


def main():
    if len(sys.argv) != 2:
        print("Input one file as an argument!")
        exit()

    file_name = sys.argv[1]

    if not path.exists(file_name):
        print("File does not exist!")
        exit()

    with open(file_name, "r") as reader:
        lines = reader.readlines()

    with open(file_name, "w") as writer:
        writer.writelines(sorted(lines))

    print("Finished!")
    exit()


if __name__ == "__main__":
    main()
