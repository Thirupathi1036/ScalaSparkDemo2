def check_voter(age):
    voter = "Not Eligible for Vote"
    if age >= 18:
        voter = "Eligible for Vote"

    return voter


if __name__ == '__main__':
    age = 25
    voter = check_voter(age)
    print (voter)
