package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource.topics
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseTopicApp()
                }
            }
        }
    }
}

@Composable
fun CourseTopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Box {
            Row {
                Image(
                    painter = painterResource(id = topic.topicImage),
                    contentDescription = stringResource(id = topic.topicName),
                    modifier = Modifier
                        .size(68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        text = stringResource(id = topic.topicName),
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 8.dp)){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                            text = topic.topicDescription.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun CourseTopicList(courseTopicList: List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(courseTopicList){topic ->
            CourseTopicCard(
                topic = topic
            )
        }
    }
}

@Composable
fun CourseTopicApp() {
    CourseTopicList(
        courseTopicList = topics // Pass the list of topics obtained from DataSource.topics
    )
}

@Composable
fun CoursesApp() {
    CourseTopicCard(Topic(R.string.architecture, 58, R.drawable.architecture))
}

@Preview
@Composable
fun GreetingPreview() {
    CoursesTheme {
        CoursesApp()
    }
}