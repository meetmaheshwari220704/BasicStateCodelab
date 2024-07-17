package com.example.basicstatecodelab

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.TextField
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.filled.KeyboardArrowDown
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Star
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    var showProfileDialog by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) { // Ensure the Box takes the full available size
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(16.dp)
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "SETTINGS",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(Icons.Default.Settings, contentDescription = "Settings icon")
                    Spacer(modifier = Modifier.width(174.dp)) // Use weight to push profile picture to the end
                    ProfilePicture(navController = navController,
                        onClick = { showProfileDialog = true },
                        modifier = modifier.clip(CircleShape)
                        )
                }
            }
            items(settingsData) { setting ->
                var expanded by remember { mutableStateOf(false) }

                SettingItem(
                    title = setting.title,
                    onClick = {
                        if (setting.title == "Profile") {
                            navController.navigate("profile") // Navigate to profile screen
                        } else {
                            expanded = !expanded
                        }
                    }
                ) {
                    AnimatedVisibility(
                        visible = expanded,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Column {
                            setting.subItems.forEach { subItem ->
                                SettingSubItem(subItem, onClick = {
                                    when (subItem) {
                                        "Profile Information" -> navController.navigate("profile")
                                        "Password Management" -> navController.navigate("passwordmanagement")
                                        "Two-Factor Authentication" -> navController.navigate("tfauthentication")
                                        "Report a Problem" -> navController.navigate("report_problem")
                                        "Submit Feedback" -> navController.navigate("feedback")
                                        "Preferred Language" -> navController.navigate("LanguageSelection")
                                        "Theme (Light/Dark Mode)" -> navController.navigate("DisplayAndAppearance")
                                    }
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ProfilePicture(navController: NavController, onClick: () -> Unit, modifier: Modifier) {
    val profilePictureDrawable = painterResource(R.drawable.profile_picture)
    Image(
        painter = profilePictureDrawable,
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(50.dp)
            .border(1.dp, Color.Black, CircleShape)
            .clip(CircleShape)
            .clickable { navController.navigate("profile") } // Navigate to profile screen
    )
}


@Composable
fun SettingItem(title: String, onClick: () -> Unit, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clickable { onClick() }
        ) {
            Text(title, style = MaterialTheme.typography.bodyLarge)
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Go to $title",
                modifier = Modifier.size(24.dp)
            )
        }
        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun SettingSubItem(title: String, onClick: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .clickable { onClick?.invoke() }
        ) {
            Text(title, style = MaterialTheme.typography.bodyMedium)
        }
        Divider(
            color = Color.LightGray,
            thickness = 0.5.dp,
            modifier = Modifier.padding(start = 32.dp, end = 16.dp)
        )
    }
}

@Composable
fun ReportProblemScreen(navController: NavController) {
    val context = LocalContext.current
    var problemDescription by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Report a Problem",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Please describe the problem you encountered:",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            value = problemDescription,
            onValueChange = { problemDescription = it },
            label = { Text("Problem Description") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (problemDescription == ""){
                    Toast.makeText(context, "Fill out the Text Field!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Problem reported", Toast.LENGTH_SHORT).show();
                    navController.popBackStack() // Go back to the previous screen
                }
                    },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun FeedbackForm(navController: NavController) {
    val context = LocalContext.current
    var serviceRating by remember { mutableStateOf(0) }
    var performanceRating by remember { mutableStateOf(0) }
    var qualityRating by remember { mutableStateOf(0) }
    var suggestions by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Feedback Form💡",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        StarRatingQuestion(
            question = "How would you rate our service?",
            onRatingChanged = { serviceRating = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        StarRatingQuestion(
            question = "How would you rate our performance?",
            onRatingChanged = { performanceRating = it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        StarRatingQuestion(
            question = "How would you rate our quality?",
            onRatingChanged = { qualityRating = it }
        )
        Spacer(modifier = Modifier.height(45.dp))
        TextField(
            value = suggestions,
            onValueChange = { suggestions = it },
            label = { Text("Any suggestions for improvement?") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Process feedback submission here
                Toast.makeText(context, "Feedback submitted", Toast.LENGTH_SHORT).show();
                navController.navigate("settings")
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Submit Feedback")
        }
    }
}

@Composable
fun StarRatingQuestion(question: String, onRatingChanged: (Int) -> Unit) {
    var selectedRating by remember { mutableStateOf(0) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = question,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        (1..5).forEach { rating ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = if (rating <= selectedRating) MaterialTheme.colorScheme.primary else Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        selectedRating = rating
                        onRatingChanged(selectedRating)
                    }
            )
        }
    }
}


@Composable
fun PasswordManagementScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        val currentPasswordState = remember { mutableStateOf(TextFieldValue()) }
        val newPasswordState = remember { mutableStateOf(TextFieldValue()) }
        val confirmPasswordState = remember { mutableStateOf(TextFieldValue()) }
        var passwordVisibility by remember { mutableStateOf(false) }
        Text(
            text = "Password Management🔑",
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            value = currentPasswordState.value,
            onValueChange = { currentPasswordState.value = it },
            label = { Text("Current Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { /* Handle next action */ }),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = newPasswordState.value,
            onValueChange = { newPasswordState.value = it },
            label = { Text("New Password") },
            visualTransformation = if (passwordVisibility) {
                PasswordVisualTransformation()
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { /* Handle next action */ }),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = confirmPasswordState.value,
            onValueChange = { confirmPasswordState.value = it },
            label = { Text("Confirm Password") },
            visualTransformation = if (passwordVisibility) {
                PasswordVisualTransformation()
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { /* Handle done action */ }),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle password change logic here
                // You can validate inputs and perform necessary actions
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Change Password")
        }
    }
}

@Composable
fun TwoFactorAuthenticationScreen(navController: NavController) {
    var selectedMethod by remember { mutableStateOf("Email") }
    var contactInfo by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var verificationCode by remember { mutableStateOf("") }
    val context = LocalContext.current

    // Define a list of valid recovery codes
    val recoveryCodes = listOf("876981", "453621")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Two-Factor Authentication",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Method Selection
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Select Verification Method:")
            Spacer(modifier = Modifier.height(25.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedMethod == "Email",
                    onClick = { selectedMethod = "Email" }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Email")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = selectedMethod == "SMS",
                    onClick = { selectedMethod = "SMS" }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "SMS")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Contact Info Input
        TextField(
            value = contactInfo,
            onValueChange = { contactInfo = it },
            label = { Text("Enter your ${selectedMethod.toLowerCase()}") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Send Button
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Send")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Save your recovery codes in a secure location. These codes can be used to access your account if you lose your device.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(text = "Recovery Codes: 876981, 453621", style = MaterialTheme.typography.bodyMedium)
    }

    // Verification Code Dialog
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Enter Verification Code") },
            text = {
                Column {
                    TextField(
                        value = verificationCode,
                        onValueChange = { verificationCode = it },
                        label = { Text("Verification Code") }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Recovery Codes: 876981, 453621",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Check if the entered code is one of the recovery codes
                        if (recoveryCodes.contains(verificationCode)) {
                            Toast.makeText(
                                context,
                                "Authentication done",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.popBackStack() // Navigate back to the previous screen
                        } else {
                            Toast.makeText(
                                context,
                                "Wrong code",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        showDialog = false
                    }
                ) {
                    Text("Verify")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}


@Composable
fun LanguageSelectionScreen(navController: NavController) {
    var selectedLanguage by remember { mutableStateOf(languages[0]) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "Choose the Language:",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 15.dp, top = 15.dp)
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(languages) { language ->
                val backgroundColor = if (selectedLanguage == language) {
                    Color.Transparent
                } else {
                    Color.Transparent
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedLanguage = language
                        }
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = language,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        RadioButton(
                            selected = selectedLanguage == language,
                            onClick = { selectedLanguage = language }
                        )

                    }
                }
            }
        }
    }
}

private val languages = listOf(
    "English", "española", "française", "Deutsch", "中国人", "日本語", "한국인", "italiano", "русский", "اردو"
)


@Composable
fun DisplayAndAppearance() {
    var checked by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 18.dp))
        Text(
            text = "Tap to switch between modes: ",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp)
        )
        Spacer(modifier = Modifier.padding(top = 18.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(if (checked) Color.Gray else Color.Transparent)
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
                    .padding(4.dp)
            ) {
                Text(
                    text = "Light Mode",
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (checked) Color.White else Color.Black
                )
            }
            Switch(
                checked = checked,
                onCheckedChange = { checked = it },
                modifier = Modifier.padding(8.dp)
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(if (!checked) Color.Gray else Color.Transparent)
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
                    .padding(4.dp)
            ) {
                Text(
                    text = "Dark Mode",
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (!checked) Color.White else Color.Black
                )
            }
        }
    }
}

