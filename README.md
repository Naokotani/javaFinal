# Inventory Manager

Simple command line bookstore inventory manager. The current state satisfies the requirements of the programming assignment 3.

## Setup
Just run `javac InventoryManager.java` and `java InventoryManager`.

## Assignment 4 notes
In the assignment we were asked to implement a remaining stock feature in the sales report. I thought it make more sense to implment it in he order function and then display it in the list function in the event someone wants to view the entire inventory. 

## Storage

Currently there is no way to persistently store the books, orders, customers etc. that you create. The most rational way to do this would be to implement a database. Alternatively you could also implement `save()` and `retrieve()` functions that could save entries to the file system, perhaps in JSON format, and then retrieve them when you launch the program. This would work on a small scale, but would be difficult to maintain and inefficient at any larger scale.


## TODO 

I created `update()` and `destroy()` functions, but didn't properly implement them. I think the easiest way to implement this would be to ask the user for some identifier, such as an ID, and then create a loop through the Objects that ends when the matching ID is found and updates or deletes the desired entry. I ideally this would be implemented with database queries in the real world.

