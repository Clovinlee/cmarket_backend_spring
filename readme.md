# Project Title

Short project description or overview.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)

## Introduction

This project is backend alternative for my <a href="https://github.com/Clovinlee/cmarket">[CMarket]</a> using springboot, java (another version of the <a href="https://github.com/Clovinlee/cmarket_backend">[backend]</a> is using Go Gin).

## Features

- REST Api using Spring, and JPA.
- Advanced queries, filters, & pagination using Pageable, Specification, and Criteria Builder.

## Getting Started

To get start, follow these steps below.

### Prerequisites

List any software or dependencies required to run the project. Include links or installation instructions if necessary.

- Java 21.0.3 (or higher)
- Gradle

### Installation

Provide step-by-step instructions to install and configure the project.

1. Clone the repository:

   ```sh
   git clone https://github.com/username/project.git

2. Init project dependency using gradle
   ```sh
   gradle build

3. Change the *resources/application.properties* accordingly

4. Compile the project
   ```
   javac cmarket.java

5. Run the project
   ```
   java cmarket.java

**Note: Currently, I dont provide seed / migration in this backend, you can use the raw_db.sql for base data**