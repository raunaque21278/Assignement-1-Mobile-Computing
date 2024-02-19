package com.example.my

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my.ui.theme.MyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                var count by remember { mutableStateOf(0) }
                var convert by remember { mutableStateOf(0) }
                val listState = rememberLazyListState()
                val listItems = listOf(
                    "  Destination 1",
                    "\n",
                    "  Destination 2",
                    "\n",
                    "  Destination 3",
                    "\n",
                    "  Destination 4",
                    "\n",
                    "  Destination 5",
                    "\n",
                    "  Destination 6",
                    "\n",
                    "  Destination 7",
                    "\n",
                    "  Destination 8",
                    "\n",
                    "  Destination 9",
                    "\n",
                    "  Destination 10",
                    "\n",
                    "  Destination 11",
                    "\n",
                    "  Destination 12",
                    "\n",
                    "  Destination 13",
                    "\n",
                    "  Destination 14",
                    "\n",
                    "  Destination 15",
                    "\n",
                    "  Destination 16",
                    "\n",
                    "  Destination 17",
                    "\n",
                    "  Destination 18",
                    "\n",
                    "  Destination 19",
                    "\n",
                    "  Destination 20",
                    "\n",
                    "\n"
                )
                Column {
                    Row {
                        Button(
                            onClick = {
                                count++
                                 },
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text("Next stop")
                        }

                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    val limitedCount = count.coerceIn(0, 20)
                    var isDistanceInKilometers by remember { mutableStateOf(true) }
                    val distance = if (isDistanceInKilometers) count * 10 else (count * 10) * 0.621371
                    val distanceCovered = if (isDistanceInKilometers) limitedCount * 10 else (limitedCount * 10) * 0.621371
                    val distanceRemaining = if (isDistanceInKilometers) (20 - limitedCount) * 10 else ((20 - limitedCount) * 10) * 0.621371
                    Column {
                        Text("  Distance covered: ${distanceCovered} ${if (isDistanceInKilometers) "km" else "miles"}")
                        Text( text = "Next is in ${distance} ${if (isDistanceInKilometers) "km" else "miles"}",
                            modifier = Modifier.padding(8.dp),

                        )
                        Text("  Distance remaining: ${distanceRemaining} ${if (isDistanceInKilometers) "km" else "miles"}")

                        Button(
                            onClick = {
                                isDistanceInKilometers = !isDistanceInKilometers
                            },
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text("Convert to ${if (isDistanceInKilometers) "Miles" else "Kilometers"}")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    ProgressforDistance(count)

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn {
                        items(listItems) { item ->
                            Text(item)

                        }
                    }
                }
            }
        }

    }



    @Composable
    fun ProgressforDistance(limitedCount: Int) {
        val progress = limitedCount / 20f
        val percentage = (progress * 100).toInt()
        val cappedProgress = progress.coerceIn(0f, 1f)
        Column {
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(12.dp)
            )
            val percentage = (cappedProgress * 100).toInt()
            Text(
                text = "Covered: $percentage%",
                modifier = Modifier.padding(top = 4.dp, start = 20.dp)
            )
        }
    }
}
