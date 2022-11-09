# Introduction
Our users are The Jarvis Linux Cluster Administration team
who manages a Linux cluster of multiple servers that are running on CentOS 7.
These servers are connected through the switch and communicate through internal IPv4 addresses.
<br>
This product is designed to help our customer, the LCA team, to document the hardware specifications of each server
and monitor server resource usage in real-time. For example,
by using this product they can detect the hardware information for other devices that are connected to this switch,
and they can also monitor the memory usage or CPU usage for this device.
The technologies that will be used to implement are Linux command lines, Bash Scripts, PostgreSQL, Docker, IDE, etc. We will discuss what these technology are, why we will use these technologies, and where we will apply them in the later sections.
<br>
**NOTE:** This is a _MVP_ (Minimum viable product,
an early version of a usable demo provided to customers who can
give feedback for future improvement), not a final version of the product. The final version of this product may be various due to the expectations of customers and better performance for this product.
# Quick Start
Use markdown code block for your quick-start commands
- Start a psql instance using psql_docker.sh
- Create tables using ddl.sql
- Insert hardware specs data into the DB using host_info.sh
- Insert hardware usage data into the DB using host_usage.sh
- Crontab setup

# Implemenation
Discuss how you implement the project.
## Architecture
![architecture_diagram](./assets/architecture_diagram.png)
## Scripts
Shell script description and usage (use markdown code block for script usage)
- psql_docker.sh
- host_info.sh
- host_usage.sh
- crontab
- queries.sql (describe what business problem you are trying to resolve)

## Database Modeling
Describe the schema of each table using markdown table syntax (do not put any sql code)
- `host_info`
- `host_usage`

# Test
How did you test your bash scripts DDL? What was the result?

# Deployment
How did you deploy your app? (e.g. Github, crontab, docker)

# Improvements
Write at least three things you want to improve
e.g.
- handle hardware updates
- blah
- blah