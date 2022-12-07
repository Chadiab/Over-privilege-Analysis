# Over-privilege-Analysis
The project is intending to instrument Android Framework in order to extract its permissions mapping

In this project, we will be using fuzz testing and symbolic execution to analyze and investigate the permissions required by the android framework while calling an API in order to create at the end a permission mapper that shows the permissions required by the framework for each API which is like an API documentation for the developers to avoid creating over privileged applications and thus avoid attacks such as privilege escalation attacks.
