package com.example.podchain.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("delivery") }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "PoDChain",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Text(
            text = "Proof of Delivery Platform",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Role Selection
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RadioButton(
                selected = selectedRole == "delivery",
                onClick = { selectedRole = "delivery" },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Delivery Personnel")

            RadioButton(
                selected = selectedRole == "customer",
                onClick = { selectedRole = "customer" },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Customer")

            RadioButton(
                selected = selectedRole == "admin",
                onClick = { selectedRole = "admin" },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Admin")
        }

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )

        // Login Button
        Button(
            onClick = {
                isLoading = true
                when (selectedRole) {
                    "delivery" -> navController.navigate("delivery")
                    "customer" -> navController.navigate("customer")
                    "admin" -> navController.navigate("admin")
                }
                isLoading = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            enabled = !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = MaterialTheme.colors.onPrimary, modifier = Modifier.size(24.dp))
            } else {
                Text("Login")
            }
        }
    }
}