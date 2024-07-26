package com.example.basicstatecodelab

import android.graphics.Paint.Align
import android.graphics.drawable.Drawable
import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.NavigationBar
import android.widget.Toast
import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.*
import kotlinx.coroutines.delay
import java.io.File
import java.io.FileOutputStream
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Badge
import androidx.compose.material.icons.filled.Notifications
import android.text.Spanned
import android.widget.Space
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.core.text.HtmlCompat
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.annotation.RawRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import android.net.Uri
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicStateCodelabTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route
                        if (currentRoute != "login") {
                            BottomNavBar(navController)
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("login") { LoginScreen(navController) }
                        composable("home") { HomeScreen(navController) }
                        composable("settings") {
                            SettingsScreen(
                                navController = navController,
                                contentPadding = innerPadding
                            )
                        }
                        composable("profile") { ProfileScreen() }
                        composable("tfauthentication") { TwoFactorAuthenticationScreen(navController) }
                        composable("report_problem") { ReportProblemScreen(navController) }
                        composable("feedback") { FeedbackForm(navController) }
                        composable("passwordmanagement") { PasswordManagementScreen() }
                        composable("description1") {
                            DescriptionScreen(
                                navController = navController,
                                drawableId = R.drawable.short_mantras,
                                headingId = R.string.short_mantras_heading,
                                descriptionId = R.string.smdesc,
                                audioRes = R.raw.shortmantras

                            )
                        }
                        composable("notification"){ NotificationScreen(navController)}
                        composable("description2") {
                            DescriptionScreen(
                                navController = navController,
                                drawableId = R.drawable.stress_and_anxiety,
                                headingId = R.string.stressandanxietyheading,
                                descriptionId = R.string.saadesc,
                                audioRes = R.raw.stressandanxiety
                            )
                        }
                        composable("description3") {
                            DescriptionScreen(
                                navController = navController,
                                drawableId = R.drawable.overwhelmed,
                                headingId = R.string.overwhelmed_heading,
                                descriptionId = R.string.overwhelmed_desc,
                                audioRes = R.raw.overwhelmed
                            )
                        }
                        composable("description4") {
                            DescriptionScreen(
                                navController = navController,
                                drawableId = R.drawable.nature_meditation,
                                headingId = R.string.nature_meditation_heading,
                                descriptionId = R.string.nature_meditation_desc,
                                audioRes = R.raw.naturemeditation
                            )
                        }
                        composable("description5") {
                            DescriptionScreen(
                                navController = navController,
                                drawableId = R.drawable.self_massage,
                                headingId = R.string.self_massage_heading,
                                descriptionId = R.string.self_massage_desc,
                                audioRes = R.raw.selfmassage
                            )
                        }
                        composable("description6") {
                            DescriptionScreen(
                                navController = navController,
                                drawableId = R.drawable.nightimage,
                                headingId = R.string.nightly_wind_down_heading,
                                descriptionId = R.string.nightly_wind_down_desc,
                                audioRes = R.raw.nightlywinddown
                            )
                        }
                        composable("LanguageSelection"){ LanguageSelectionScreen(navController)}
                        composable("DisplayAndAppearance"){ DisplayAndAppearance()}
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showForgotPasswordDialog by remember { mutableStateOf(false) }
    var showEmailConfirmationDialog by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    val correctUsername = "meet_2004_"
    val correctPassword = "22072004"
    val validEmail = "meetmaheshwari.220704@gmail.com"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Forgot Password?",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodySmall.copy(textDecoration = TextDecoration.Underline),
            modifier = Modifier
                .clickable { showForgotPasswordDialog = true }
                .padding(bottom = 24.dp)
        )

        Row {
            Button(
                onClick = {
                    if (username == correctUsername && password == correctPassword) {
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        showError = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text ="Login")
            }
        }
        if (showError) {
            Text(
                text = "Either the username or password is incorrect",
                color = Color.Red,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }

    if (showForgotPasswordDialog) {
        AlertDialog(
            onDismissRequest = { showForgotPasswordDialog = false },
            title = { Text("Forgot Password")},
            text = {
                Column {
                    Text("Enter your email address:")
                    Spacer(Modifier.height(10.dp))
                    TextField(
                        value = email,
                        onValueChange = {
                            email = it
                            emailError = false
                        },
                        label = { Text("Email") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (emailError) {
                        Text(
                            text = "Invalid email address",
                            color = Color.Red,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (email == validEmail) {
                            showForgotPasswordDialog = false
                            showEmailConfirmationDialog = true
                            // Logic to send email
                        } else {
                            emailError = true
                        }
                    }
                ) {
                    Text("Submit")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showForgotPasswordDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showEmailConfirmationDialog) {
        AlertDialog(
            onDismissRequest = { showEmailConfirmationDialog = false },
            title = {
                Text(
                    text = "Password Recovery",
                    style = MaterialTheme.typography.headlineMedium
                )
            },
            text = {
                Text("The password is '22072004'\nAn email to change your password has been sent to your email.")
            },
            confirmButton = {
                Button(
                    onClick = { showEmailConfirmationDialog = false }
                ) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    var showWelcomeText by remember { mutableStateOf(true) }
    val fontSize by remember { mutableIntStateOf(32) }

    LaunchedEffect(Unit) {
        delay(1000)
        showWelcomeText = false
        navController.navigate("home") {
            popUpTo("welcome") { inclusive = true }
        }
    }

    val animatedFontSize by animateIntAsState(targetValue = fontSize)
    val customFont = FontFamily(
        Font(R.font.custom_font, FontWeight.Normal) // Replace with your actual font resource
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = showWelcomeText,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Text(
                text = "Welcome!!",
                fontSize = animatedFontSize.sp,
                color = Color.Black,
                style = TextStyle(fontFamily = customFont),
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Meet Maheshwari", style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.width(5.dp))
                        ProfilePictureNavigationDrawer(navController = navController, onClick = {
                            coroutineScope.launch { drawerState.close() }
                            navController.navigate("profile") })
                    }
                    Column {
                        NavigationDrawerItem(
                            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                            label = { Text(text = "Settings") },
                            selected = false,
                            onClick = {
                                coroutineScope.launch { drawerState.close() }
                                navController.navigate("settings")
                            }
                        )
                        NavigationDrawerItem(
                            icon = { Icon(Icons.Default.Person, contentDescription = null) },
                            label = { Text(text = "Profile") },
                            selected = false,
                            onClick = {
                                coroutineScope.launch { drawerState.close() }
                                navController.navigate("profile")
                            }
                        )
                        NavigationDrawerItem(
                            icon = { Icon(Icons.Default.Notifications, contentDescription = null) },
                            label = { Text(text = "Notifications") },
                            selected = false,
                            onClick = {
                                coroutineScope.launch { drawerState.close() }
                                navController.navigate("notification")
                            }
                        )
                    }
                }
            }
        }
    ) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {

                IconButton(
                    onClick = { coroutineScope.launch { drawerState.open() } },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Box {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "List icon",
                            tint = Color.Black
                        )
                        Badge(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                        )
                    }
                }

                Text(
                    text = "Soothe App",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                IconButton(
                    onClick = { navController.navigate("settings") },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings icon",
                        tint = Color.Black
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            SearchBar(Modifier.padding(horizontal = 16.dp))
            HomeSection(title = R.string.alignyourbodyheading) {
                AlignYourBodyRow()
            }
            HomeSection(title = R.string.favouritecollectionheading) {
                FavouriteCollectionsGrid(navController) // Passed navController
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun NotificationScreen(navController: NavController) {
    var notifications by remember { mutableStateOf(listOf(
        "Drink a glass of water to stay hydrated.",
        "Have a healthy snack to maintain your energy levels.",
        "Time to take a break and have a nutritious meal."
    )) }

    val times = listOf(
        "2 min ago",
        "5 min ago",
        "10 min ago"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(56.dp)) // Space for the header
            notifications.forEachIndexed { index, notification ->
                NotificationBox(
                    notification = notification,
                    time = times[index],
                    onClick = {
                        notifications = notifications.toMutableList().apply { removeAt(index) }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = "Notifications",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun NotificationBox(notification: String, time: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.TopStart
    ) {
        Column {
            Text(
                text = notification,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = time,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ProfilePictureNavigationDrawer(navController: NavController, onClick: () -> Unit) {
    Image(
        painter = painterResource(R.drawable.profile_picture),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(30.dp)
            .border(0.5.dp, Color.Gray, CircleShape)
            .clip(CircleShape)
            .clickable { navController.navigate("profile") } // Navigate to profile screen
    )
}

@Composable
fun ModalDrawerSheet(
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(MaterialTheme.colorScheme.surface),
        content = content
    )
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    // State for storing the text in the TextField
    var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = { newText ->
            searchText = newText  // Update the state on text change
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = Color.Black,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier

    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                .clickable(
                    onClick = onClick,
                    interactionSource = interactionSource,
                    indication = rememberRipple(bounded = true)
                )
        )
        Text(text = stringResource(text))
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(AlignYourBodyData) { item ->
            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text,
                onClick = {
                    Toast.makeText(context, context.getString(item.text) , Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
fun FavouriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @RawRes audioRes: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = true),
                onClick = {
                    when (text) {
                        R.string.short_mantras -> navController.navigate("description1")
                        R.string.stress_and_anxiety -> navController.navigate("description2")
                        R.string.overwhelmed -> navController.navigate("description3")
                        R.string.nature_meditation -> navController.navigate("description4")
                        R.string.self_massage -> navController.navigate("description5")
                        R.string.nightimage -> navController.navigate("description6")
                    }
                }
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun FavouriteCollectionsGrid(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favouriteCollectionsData) { item ->
            FavouriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                audioRes = item.audioRes,
                navController = navController,
                modifier = Modifier.height(80.dp)
            )
        }
    }
}

@Composable
fun getHtmlStringAsAnnotatedString(context: Context, @StringRes resId: Int): AnnotatedString {
    val rawHtmlString = context.getString(resId)
    val spanned: Spanned = HtmlCompat.fromHtml(rawHtmlString, HtmlCompat.FROM_HTML_MODE_LEGACY)

    return buildAnnotatedString {
        append(spanned.toString())

        spanned.getSpans(0, spanned.length, Any::class.java).forEach { span ->
            val start = spanned.getSpanStart(span)
            val end = spanned.getSpanEnd(span)

            when (span) {
                is android.text.style.StyleSpan -> {
                    if (span.style == android.graphics.Typeface.BOLD) {
                        addStyle(SpanStyle(fontWeight = FontWeight.Bold), start, end)
                    } else if (span.style == android.graphics.Typeface.ITALIC) {
                        addStyle(SpanStyle(fontStyle = FontStyle.Italic), start, end)
                    }
                }
                is android.text.style.UnderlineSpan -> {
                    addStyle(SpanStyle(textDecoration = TextDecoration.Underline), start, end)
                }
            }
        }
    }
}

@Composable
fun DescriptionScreen(
    navController: NavController,
    @DrawableRes drawableId: Int,
    @StringRes headingId: Int,
    @StringRes descriptionId: Int,
    @RawRes audioRes: Int // Audio resource
) {
    val context = LocalContext.current
    val heading = getHtmlStringAsAnnotatedString(context, headingId)
    val description = getHtmlStringAsAnnotatedString(context, descriptionId)
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(id = drawableId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .size(48.dp)
                            .padding(8.dp)
                            .align(Alignment.TopStart)
                            .background(
                                Color.Transparent,
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = heading,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = {
                            mediaPlayer?.release()
                            mediaPlayer = MediaPlayer.create(context, audioRes).apply { start() }
                        },
                        modifier = Modifier
                            .size(35.dp)
                            .background(color = Color.White, shape = CircleShape)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_play), // Use your play button drawable
                            contentDescription = "Play",
                            tint = Color.Black
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(1.dp))
            }
            item {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

data class NavigationItem(val title: String, val icon: ImageVector)

@Composable
fun BottomNavBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val items = listOf(
        NavigationItem("Home", Icons.Filled.Home),
        NavigationItem("Settings", Icons.Filled.Settings)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.title.lowercase(),
                onClick = {
                    navController.navigate(item.title.lowercase()) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
