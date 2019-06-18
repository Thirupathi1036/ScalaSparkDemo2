def checkType(age):
    age_des = "Infants"
    if age <= 3:
        age_des
    elif age > 3 and age <= 5:
        age_des = "Kids"
    elif age > 5 and age <= 12:
        age_des = "Younger"
    elif age > 12 and age <= 19:
        age_des = "Teenager"
    elif age > 19 and age <= 30:
        age_des = "Youth"
    elif age > 30 and age <= 50:
        age_des = "Middle Age"
    else:
        age_des = "Older"
    return age_des


if __name__ == '__main__':
    age = 45
    ageType = checkType(age)
    print(ageType)
