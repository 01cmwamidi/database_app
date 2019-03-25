package com.clinton.database_app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "accounts")
public class Account{

        @PrimaryKey(autoGenerate = true)
        public int id;

        public String name;

        public String accNumber;

        public double balance;

        //getter and setters
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAccNumber() {
                return accNumber;
        }

        public void setAccNumber(String accNumber) {
                this.accNumber = accNumber;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }
}

