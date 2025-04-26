Solution-HomeWork-7
Hey! This project includes two design patterns: Iterator and Mediator. Here's what it's all about:

Part 1 — Iterator Pattern
What is it about:
I created an episode player for a small platform similar to Netflix. A TV series consists of several seasons, and each season stores its episodes in its own way (e.g., using ArrayList, LinkedList, or even a lazy file loader). To make things easier for the UI team, I used the Iterator pattern. The iterator allows you to loop through the episodes without worrying about how they are stored.

What was done:
Implemented three iterators for traversing episodes:

SeasonIterator — normal order.

ReverseSeasonIterator — reverse order.

ShuffleSeasonIterator — random order, with a fixed seed for reproducible results.

Created BingeIterator, which lets you seamlessly watch from Season 1, Episode 1, all the way through to the finale without manual jumps.

Why is this important:
Iterators simplify collection traversal by hiding the underlying implementation details. They allow you to use the same code with different types of collections and give you the flexibility to choose the traversal order (normal, reverse, or random).

Part 2 — Mediator Pattern
What is it about:
In this part, I implemented the Mediator pattern, which helps manage the interaction between aircraft at an airport. In real life, airplanes would cause chaos if they communicated directly, so the ControlTower mediates all communication and scheduling between the aircraft.

What was done:
Created ControlTower, which manages two queues: one for landing and one for takeoff.

Implemented an emergency landing mechanism for planes with low fuel or when a "MAYDAY" message is sent.

Each type of aircraft (passenger, cargo, helicopter) reacts differently to the tower's commands.

A simulation spawns 10 random aircraft with different fuel levels, and the tower decides who lands and who takes off in real-time.

Why is this important:
Using Mediator helps centralize the control and coordination of actions, making the system easier to maintain. Aircraft don't need to worry about how to communicate with each other; they all interact through the mediator (the control tower).
