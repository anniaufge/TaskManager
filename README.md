# Task Manager
SE350 Project

## Checklist
* Working Individually
* Using Java (JavaSE-21)
* GitHub repository link: https://github.com/anniaufge/TaskManager
* Entry point: src/main/Main.java

## Project Description
A task management system where users can create, organize, and track tasks of different types, priorities, statuses, and deadlines.

## Goals for the Final Submission
I plan to demo a working GUI that lets users manage tasks through different workflow states, with sorting and undo/redo support.

## Sprint 3 Notes
Implemented two new design patterns (State and Strategy) and refactored classes to accomodate. I didn't face many issues implementing the patterns but a concern I have is making sure the state transitions stay clean as more features get added. I also want to figure out how the patterns connect to the Swing GUI in the upcoming sprints.

## Sprint 4 Notes
Implemented two more design patterns (Command and Observer). The Command pattern enables new undo/redo functionality for task creation, deletion, and state changes. The Observer pattern notifies listeners when the project is being updated. No major issues to report.

## Sprint 5 Notes
Implemented two more design patterns (Factory and Builder). The Factory pattern creates different task types with default values. The Builder allows for flexible task construction through a director.

## Final Submission Notes
Implemented working GUI and ensured all design patterns work together.

## Bug Fixes
- Back button bypassed the command pattern, corrected status sort order to follow the natural workflow (TODO -> IN_PROGRESS -> IN_REVIEW -> DONE).

## Known Issues
- State boundary messages print to console instead of GUI
- No input validation on Add Task form
- Factory creators are available but the Add Task dialog uses builder pattern for task creation
