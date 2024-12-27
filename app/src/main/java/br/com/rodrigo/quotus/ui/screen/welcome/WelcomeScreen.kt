package br.com.rodrigo.quotus.ui.screen.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodrigo.quotus.ui.theme.Typography

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(40.dp)
    ) {
        Column {
            WelcomeHeader()

            WelcomeContent()
        }

        QuotusButton(
            text = "Começar",
            onClick = { }
        )
    }
}

@Composable
fun QuotusButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text.uppercase(),
            style = Typography.labelLarge.copy(
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun WelcomeContent() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Veja como funciona:",
            style = Typography.bodyLarge
        )

        WelcomeHowItWorksTip(
            title = "Grupos de cotas organizados",
            subtitle = "Os grupos de cotas são organizadas em uma lista",
            imageVector = Icons.Rounded.Menu
        )

        WelcomeHowItWorksTip(
            title = "Cotas pagas",
            subtitle = "Você consegue ver facilmente quem pagou ou não a cota",
            imageVector = Icons.Rounded.CheckCircle
        )

        WelcomeHowItWorksTip(
            title = "Gerenciamento",
            subtitle = "Com o Quotus você consegue gerenciar facilmente as suas cotas",
            imageVector = Icons.Filled.Build
        )
    }
}

@Composable
fun WelcomeHowItWorksTip(
    title: String,
    subtitle: String,
    imageVector: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = ""
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = title,
                style = Typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = subtitle,
                style = Typography.bodyMedium
            )
        }
    }
}

@Composable
fun WelcomeHeader() {
    Row {
        Text(
            text = "Boas vindas ao Quotus",
            style = Typography.headlineLarge.copy(
                color = Color.Green
            )
        )
    }

    Spacer(modifier = Modifier.height(24.dp))

    Row {
        Text(
            text = "Tenha todas as suas cotas organizadas em apenas um app",
            style = Typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}