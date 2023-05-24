/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelab.basiclayouts

import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
//import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewee_230521.R
import org.w3c.dom.Text
import kotlin.math.round
//mport com.codelab.basiclayouts.ui.theme.MySootheTheme
import androidx.compose.material.TextField as TextField
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  //ShowTotalFeedback()
            MyApp()
        }
    }
}

@Composable
fun MainTopBar(
    modifier: Modifier = Modifier
) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.foundation.Image(
            modifier = Modifier
                .width(100.dp)
                .height(27.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.main_logo),
            contentDescription = null
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                20.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .clickableWithoutRipple(
                        interactionSource = interactionSource,
                        onClick = { }
                    ),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                contentDescription = "search",
            )
            Icon(
                modifier = Modifier
                    .width(32.dp)
                    .height(18.dp)
                    .clickableWithoutRipple(
                        interactionSource = interactionSource,
                        onClick = { }
                    ),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_menu),
                contentDescription = "menu"
            )
        }
    }
}

// 메인화면_면접결과
@Composable
fun MainFeedbackCard(
    modifier: Modifier = Modifier,
    index: Int
) {
    var usBlue = Color(red = 37, green = 88, blue = 171)

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(usBlue.copy(alpha = 0.2f))
                .alpha(0.5f)
        ) {
            Text(
                text = (index + 1).toString(),
                modifier = Modifier
                    .weight(1f, fill = true)
                    .padding(
                        horizontal = 25.dp,
                        vertical = 10.dp
                    ),
                textAlign = TextAlign.Left,
                color = usBlue,
                fontSize = 70.sp
            )
            Column(
                modifier = Modifier
                    .size(120.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = alignMainFeedbackData[index],
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp),
                    fontSize = 20.sp
                )
                Text(
                    stringResource(id = R.string.main_title_day),
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp),
                    fontSize = 10.sp
                )
            }
        }
    }
}


// 메인화면_면접결과(Grid)
@Composable
fun MainFeedbackCardGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(200.dp),
        rows = GridCells.Fixed(1)
    ) {

        items(alignMainFeedbackData.size) { index ->
            MainFeedbackCard(
                index = index
            )
        }
    }
}

// 메인화면_면접세부결과
@Composable
fun DetailFeedbackCard(
    modifier: Modifier = Modifier,
    detailTitleIndex: Int,
    detailTitle: String,
) {
    // 컬러 따로 관리!!!
    var usBlue = Color(red = 37, green = 88, blue = 171)

    Box(
        modifier = modifier
            .background(usBlue.copy(alpha = 0.05f))
            .border(1.dp, (usBlue.copy(alpha = 0.5f)), RoundedCornerShape(10.dp)),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = (detailTitleIndex + 1).toString(),
                modifier = Modifier,
                textAlign = TextAlign.Left,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
                color = Color.Gray
            )
            Text(
                text = detailTitle,
                modifier = Modifier,
                textAlign = TextAlign.Left,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

// 메인화면_면접세부결과(Grid)
@Composable
fun DetailFeedbackCardGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        // 그리드 각 항목들이 사이즈 비율이 안 맞았던 이유
        // -> LazyHorizontalGrid 높이에 고정 값 주려면 패딩 값이나 space 값 도 계산 해서 해줘야…
        modifier = modifier.height(220.dp),
        rows = GridCells.Fixed(2),
        content = {
            items(alignDetailFeedbackData.size) { index ->
                DetailFeedbackCard(
                    modifier = Modifier.size(100.dp),
                    detailTitleIndex = index,
                    detailTitle = alignDetailFeedbackData[index]
                )
            }
        })
}


@Composable
fun HomeSection(
    @StringRes title: Int,
    username: String = "김길동",
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            "$username" + stringResource(id = title),
            style = MaterialTheme.typography.h6,
            color = Color.DarkGray,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 45.dp,
                    bottom = 15.dp
                )
                .padding(horizontal = 20.dp)
        )
        content()
    }
    // Implement composable here
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    // Implement composable here
    Column(modifier = modifier.fillMaxSize()) {
        MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 25.dp))
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(1.dp)
//                .background(Color.Gray.copy(alpha = 0.5f))
//        )
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HomeSection(title = R.string.main_title) {
                MainFeedbackCardGrid()
            }
            HomeSection(title = R.string.Detail_title) {
                DetailFeedbackCardGrid()
            }
//        Spacer(Modifier.height(20.dp))
        }
    }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = Color(
            red = 245,
            green = 246,
            blue = 248
        ),//MaterialTheme.colors.background,
        modifier = Modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Play")
            },
            selected = true,
            onClick = {}
        )

        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null
                )
            },
            label = {
                Text("Play")
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null
                )
            },
            label = {
                Text("My page")
            }
        )
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(
                Modifier.padding(padding)
            )
        }
    }

}

private val alignDetailFeedbackData = arrayOf(
    "자기소개", "경험",
    "직무1", "직무2",
    "경력1", "경력2",
    "적성1", "적성2",
)

private val alignMainFeedbackData = arrayOf(
    "230313", "230413", "230513", "230613",
    "230313", "230413", "230513", "230613",
)

fun Modifier.clickableWithoutRipple(
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
) = composed(
    factory = {
        this.then(
            Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            )
        )
    }
)


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MyPreview() {
    MyApp()
}

@Preview(widthDp = 500, heightDp = 500)
@Composable
fun MyPreview2() {
    MyApp()
}

@Preview(showBackground = true)
@Composable
fun MainTopBarPreview() {
    MainTopBar()
}