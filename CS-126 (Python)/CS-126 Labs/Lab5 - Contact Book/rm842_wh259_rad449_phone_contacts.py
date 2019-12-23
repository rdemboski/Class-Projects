# Ricardo McCrary, Hanyue Wang,
# lab5 phone contacts
# section 001 10/08/19
# with the add contact function we decided that
# it would be a good idea to create a key combining the
# first and last name of the contact and then assigning
# it the values below for the value in the dictonary


def add_contact(contacts, first_name, last_name, email, phone_number, age):
    name = make_key(first_name, last_name)
    contacts[name] = [first_name, last_name, email, phone_number, age]
# with the make key function we made it where
# it returns the concatination of first and last name
# with a space between


def make_key(first_name, last_name):
    return first_name + " " + last_name
# for the has contact function
# we decided to set name = to make key and use
# an if staement to check if name was in contacts
# thus it would return true or false depending


def has_contact(contacts, first_name, last_name):
    name = make_key(first_name, last_name)
    if name in contacts:
        return True
    else:
        return False
# for this function we used name is = to make key
# and then we used if name in contacts to do true or false
# if true it would return the contacts age


def get_contact_age(contacts, first_name, last_name):
    name = make_key(first_name, last_name)
    if name in contacts:
        return contacts[name][4]
# same set up for get email of the contact only diffrence
# is it would return the email instead.


def get_contact_email(contacts, first_name, last_name):
    name = make_key(first_name, last_name)
    if name in contacts:
        return contacts[name][2]
# same set up as get contact age just would return phone number
# instead


def get_contact_phone_number(contacts, first_name, last_name):
    name = make_key(first_name, last_name)
    if name in contacts:
        return contacts[name][3]
# for this one we wanted to make it to where we could update the
# age of the contact. to do that we set up a function with
# the dictonary, first and last name and age
# from that we created  an if statement calling has contact
# if it returned true it set the contacts age to the new one and checked it


def update_contact_age(contacts, first_name, last_name, age):
    name = make_key(first_name, last_name)
    if has_contact(contacts, first_name, last_name):
        contacts[name][4] = age
        if contacts[name][4] == age:
            return True
        else:
            return False
        return True
    else:
        return False
# we repeated the same process for updating the email of a contact as we
# would have for updating their age


def update_contact_email(contacts, first_name, last_name, email):
    name = make_key(first_name, last_name)
    if has_contact(contacts, first_name, last_name):
        contacts[name][2] = email
        if contacts[name][2] == email:
            return True
        else:
            return False
        return True
    else:
        return False
# followed the same steps for updating age but only to update phone number


def update_contact_phone_number(contacts, first_name, last_name, phone_number):
    name = make_key(first_name, last_name)
    if has_contact(contacts, first_name, last_name):
        contacts[name][3] = phone_number
        if contacts[name][3] == phone_number:
            return True
        else:
            return False
        return True
    else:
        return False

# this part is an atempt at the delete contact func


def remove_contact(contacts, first_name, last_name):
    name = make_key(first_name, last_name)
    if has_contact(contacts, first_name, last_name):
        del contacts[name]
        return first_name, last_name
    else:
        return None
