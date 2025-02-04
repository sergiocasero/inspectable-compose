package com.sergiocasero.inspectable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var inspect by remember { mutableStateOf(false) }

        InspectableUI(inspect) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { inspect = !inspect }, modifier = Modifier.inspectable()) {
                    Text("Enable inspector")
                }
                Counter()
                repeat(20) {
                    Text("Item $it", modifier = Modifier.inspectable())
                }
            }
        }

    }
}

@Composable
fun Counter() {

    var counter by remember { mutableStateOf(0) }

    Button(onClick = { counter++ }, modifier = Modifier.inspectable()) {
        Text("Update counter!")
    }

    Text("You clicked $counter times!!", modifier = Modifier.inspectable())
}