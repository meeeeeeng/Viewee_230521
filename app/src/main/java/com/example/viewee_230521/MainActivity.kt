//@UnstableApi //@UnstableApi
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

package com.example.viewee_230521


import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

import com.example.viewee_230521.ui.theme.BackgroundGrey
import com.example.viewee_230521.ui.theme.CustomOrange
import com.example.viewee_230521.ui.theme.UsBlue
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.SimpleExoPlayer

import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory


import androidx.media3.common.util.Util.getUserAgent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  //ShowTotalFeedback()
            MyApp()
            // DataInputScreen()
            //PrepareScreen()
            // PlayAfterFeedbackApp()
            //PlayVideo(this)

            //PlayVideoScreen(context = this, "file://app/frt/kk3.mp4")


        }
    }
}

@Composable
fun MainTopBar(
    modifier: Modifier = Modifier
) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(100.dp)
                .height(27.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.main_logo),
            contentDescription = null
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                20.dp, alignment = Alignment.CenterHorizontally
            )
        ) {
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .clickableWithoutRipple(interactionSource = interactionSource, onClick = { }),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                contentDescription = "search",
            )
            Icon(
                modifier = Modifier
                    .width(32.dp)
                    .height(18.dp)
                    .clickableWithoutRipple(interactionSource = interactionSource, onClick = { }),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_menu),
                contentDescription = "menu"
            )
        }
    }
}

// 메인화면_면접결과
@Composable
fun MainFeedbackCard(
    modifier: Modifier = Modifier, index: Int
) {


    Surface(
        shape = MaterialTheme.shapes.small, modifier = modifier.clip(RoundedCornerShape(8.dp))

    ) {
        Row(
            modifier = Modifier

                .height(100.dp)
                .width(230.dp)
                .background(UsBlue.copy(alpha = 0.05f))

                .alpha(0.7f)
                //.border(1.dp, (UsBlue.copy(alpha = 0.4f)), RoundedCornerShape(10.dp))

        ) {
            Text(
                text = (index + 1).toString(), modifier = Modifier
                    .weight(1f, fill = true)
                    .padding(
                        horizontal = 25.dp, vertical = 10.dp
                    ), textAlign = TextAlign.Left, color = UsBlue, fontSize = 70.sp
            )
            Column(
                modifier = Modifier.size(120.dp), verticalArrangement = Arrangement.Center
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
        contentPadding = PaddingValues(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .padding(vertical = 15.dp)
            .height(200.dp),
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


    Box(
        modifier = modifier
            .background(UsBlue.copy(alpha = 0.05f), RoundedCornerShape(8.dp))

            //.border(1.dp, (UsBlue.copy(alpha = 0.5f)), RoundedCornerShape(10.dp)),
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
                color = UsBlue.copy(alpha = 0.5f)
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
    LazyHorizontalGrid(contentPadding = PaddingValues(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        // 그리드 각 항목들이 사이즈 비율이 안 맞았던 이유
        // -> LazyHorizontalGrid 높이에 고정 값 주려면 패딩 값이나 space 값 도 계산 해서 해줘야…
        modifier = modifier
            .padding(vertical = 15.dp)
            .height(200.dp),
        rows = GridCells.Fixed(2),
        content = {
            items(alignDetailFeedbackData.size) { index ->
                DetailFeedbackCard(
                    modifier = Modifier.size(130.dp),
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
            color = Color.Gray,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 65.dp, bottom = 20.dp
                )
                .padding(horizontal = 20.dp)
        , fontWeight= FontWeight.SemiBold
        )
        content()
    }
    // Implement composable here
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    username: String = "김길동",
) {

CompositionLocalProvider(LocalRippleTheme provides Utils.NoRippleTheme) {
    Column(modifier = modifier.fillMaxSize()) {
        MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 25.dp))
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(1.dp)
//                .background(Color.Gray.copy(alpha = 0.5f))
//        )


        Divider(color = Color.Gray.copy(.5f), thickness = .5.dp)
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = " 환영합니다!  "+ "$username"+"님 :)" ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(top = 15.dp),

                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Left,
                fontSize = 23.sp,
                color = Color.DarkGray.copy(.8f)
            )
            MainCardScreen()


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
}



@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = Color(
            red = 245, green = 246, blue = 248
        ),//MaterialTheme.colors.background,
        modifier = Modifier
    ) {
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = null
            )
        }, label = {
            Text("Play")
        }, selected = true, onClick = {})

        BottomNavigationItem(selected = false, onClick = { }, icon = {
            Icon(
                imageVector = Icons.Default.PlayArrow, contentDescription = null
            )
        }, label = {
            Text("Play")
        })
        BottomNavigationItem(selected = false, onClick = { }, icon = {
            Icon(
                imageVector = Icons.Default.Face, contentDescription = null
            )
        }, label = {
            Text("My page")
        })
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        Scaffold(bottomBar = { BottomNavigation() }) { padding ->
            HomeScreen(
                Modifier.padding(padding)
            )
        }
    }

}

///===============


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainCardPagerScreen(modifier: Modifier, images: List<Int>) {
    val pagerState = rememberPagerState()


    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(modifier = Modifier
            .clickable { }
            .height(270.dp)
            .width(400.dp)
            .padding(horizontal = 20.dp)


            .shadow(
                shape = RoundedCornerShape(10.dp),
                ambientColor = Color.Gray.copy(alpha = 0.2f),
                spotColor = Color.Gray,
                elevation = 5.dp
            ), Alignment.Center


        ) {
            HorizontalPager(pageCount = 5, state = pagerState) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(id = images[it]),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
            }
        }

        var pageCount = 5
        //  pagerState = pagerState

        Row(
            Modifier
                /// .height(40.dp)
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) CustomOrange else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(5.dp)


                )
            }
        }

    }
}


@Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainCardScreen(
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))
        //  Surface(modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth()
            //.height(50.dp)
            // .padding(bottom = 20.dp),
            , verticalAlignment = Alignment.CenterVertically
        ) {


        }

        MainCardPagerScreen(modifier = Modifier.padding(vertical = 30.dp), images = MainCardData)


    }


}


//===================================== 면접플레이버튼 화면 ====================================
@Composable
fun Playbutton(modifier: Modifier) {

    Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_play_button),
        contentDescription = null,

        modifier = Modifier
            .padding(top = 180.dp)
            //.clickable { }
            .fillMaxWidth()


    )


}

@Composable
fun PlaybuttonScreen() {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))

        Surface(modifier = Modifier) {


            Box(modifier = Modifier) {
                Playbutton(modifier = Modifier.padding(top = 70.dp))
                Column(
                    modifier = Modifier
                        .height(900.dp)
                        .padding(vertical = 0.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    CustomTitleText(modifier = Modifier.padding(top = 90.dp), "오늘의 면접 시작하기")/* Text(
                                text = "오늘의 면접 시작하기",
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontStyle = FontStyle.Normal,
                                fontSize = 15.sp,
                                color = Color.Gray
                            )*/


                    QuitButton(modifier = Modifier

                        .padding(vertical = 5.dp, horizontal = 155.dp), onClick = {})

                }
            }
        }

    }
}


//===================================== 자기소개서 선택 화면 ====================================

@Composable
fun ChoicePR() {

    Column(modifier = Modifier.fillMaxSize()) {
        //MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "back",
                    modifier = Modifier
                        .alpha(.7f)
                        .padding(horizontal = 30.dp)
                )
            }

        }
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomTitleText(
                modifier = Modifier.padding(top = 10.dp, bottom = 50.dp), "자신의 자기소개서를 선택해주세요."
            )

            ChoicePRCardGrid()

            NextButton(modifier = Modifier.padding(horizontal = 30.dp), onClick = {})


        }
    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun ChoicePRScreen() {

    ChoicePR()
}


@Composable
fun ChoicePRCard(
    modifier: Modifier = Modifier, PRTitle: String, PRContent: String
) {


    Box(
        modifier = modifier
            //.background(UsBlue.copy(alpha = 0.05f))
            .border(1.dp, (UsBlue.copy(alpha = 0.5f)), RoundedCornerShape(10.dp)),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = PRTitle,
                modifier = Modifier.padding(bottom = 35.dp),
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = UsBlue.copy(.8f)
            )

            Text(
                text = PRContent,
                modifier = Modifier,
                textAlign = TextAlign.Left,
                fontSize = 10.sp,
                color = Color.Gray
            )
        }
    }
}


@Composable
fun ChoicePRCardGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(contentPadding = PaddingValues(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        // 그리드 각 항목들이 사이즈 비율이 안 맞았던 이유
        // -> LazyHorizontalGrid 높이에 고정 값 주려면 패딩 값이나 space 값 도 계산 해서 해줘야…
        modifier = modifier.height(385.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(PRTitleData.size) { index ->
                ChoicePRCard(
                    modifier = Modifier.size(150.dp),
                    PRTitle = PRTitleData[index],
                    PRContent = PRContentData[index]

                )

            }
        })
}


//=============================== 면접준비 화면 =======================================


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreparePlayPagerScreen(modifier: Modifier, images: List<Int>) {
    val pagerState = rememberPagerState()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey),
        verticalArrangement = Arrangement.Center
    ) {

        HorizontalPager(pageCount = 5, state = pagerState) {
            Image(
                modifier = Modifier.padding(vertical = 40.dp),
                painter = painterResource(id = images[it]),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
        }

        Text(
            "면접 화면은 어둡지 않은,\n밝은 환경에서 진행 해주세요",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            fontSize = 13.sp,
            color = Color.Gray
        )

        val pageCount = 3
        //  pagerState = pagerState

        Row(
            Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(5.dp)


                )
            }
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PrepareScreen(
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGrey),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))
        //  Surface(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "back",
                    modifier = Modifier
                        .alpha(.7f)
                        .padding(horizontal = 30.dp)
                )
            }
        }
        CustomTitleText(
            modifier = Modifier
                .fillMaxWidth()

                .padding(top = 10.dp, bottom = 10.dp), "면접 진행 시 꼭 지켜주세요!"
        )

        PreparePlayPagerScreen(
            modifier = Modifier.padding(vertical = 30.dp), images = prepareImageData
        )

        NextButton(modifier = Modifier.padding(horizontal = 30.dp), onClick = {})
    }


}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PrepareScreenPreview() {

    PrepareScreen()
}


////준비화면_카메라화면_준비_단계
@Composable
fun PrepareCam() {

    Column(
        modifier = Modifier
            .fillMaxSize(.5f)
            .background(BackgroundGrey),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "back",
                    modifier = Modifier
                        .alpha(.7f)
                        .padding(horizontal = 25.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundGrey),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "조용하고 밝은 장소에서 카메라를 \n" + "눈높이에 맞춰 고정시킨 후 , \n" + "면접을 시행해주세요.\n" + "\n" + "총 N개의 질문으로 생각시간은 N초, \n" + "답변시간은 N초입니다.\n" + "\n" + "준비가 되셨다면 다음버튼을 눌러 주세요.",

                Modifier.fillMaxWidth()

                // .padding(bottom = 300.dp),
                ,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = UsBlue

            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                painter = painterResource(id = R.drawable.ic_prepare_cam),

                contentDescription = ""
            )

            NextButton(modifier = Modifier.padding(horizontal = 20.dp), onClick = {})
        }
    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PrepareCamScreen() {

    PrepareCam()

}

//=================================== 정보기입화면 =======================================


// 다음 버튼
@Composable
fun NextButton(
    modifier: Modifier = Modifier, onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .clip(RoundedCornerShape(10.dp)),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = UsBlue
        )
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_nextbutton),
            contentDescription = "next"
        )
    }
}

// 종료 버튼
@Composable
fun QuitButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier.clickable { onClick() },

        text = "종료하기",
        fontSize = 13.sp,
        color = CustomOrange,
        textDecoration = TextDecoration.Underline
    )
}

// 정보 입력 카드
@Composable
fun DataInputCard(
    modifier: Modifier = Modifier,
    dataName: String,
    dataValue: String,
    onTextChanged: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dataName,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left,
            fontStyle = FontStyle.Normal,
            fontSize = 13.sp,
            color = Color.Gray
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            value = dataValue,
            onValueChange = { onTextChanged(it) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BackgroundGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun CustomTitleText(
    modifier: Modifier = Modifier,
    text: String = "자신의 정보를 입력해주세요.",
) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = UsBlue
    )
}

// 정보 입력 화면 1
@Composable
fun DataInputScreen1(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTitleText(
            modifier = Modifier.padding(top = 40.dp),
            text = "자신의 정보를 입력해주세요.",
        )
        Column(
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(
                10.dp, alignment = Alignment.CenterVertically
            )
        ) {
            DataInputCard(dataName = "이름", dataValue = "", onTextChanged = {})
            DataInputCard(dataName = "생년월일", dataValue = "", onTextChanged = {})
            DataInputCard(dataName = "학력", dataValue = "", onTextChanged = {})
            DataInputCard(dataName = "경력", dataValue = "", onTextChanged = {})
        }
        NextButton(modifier = Modifier.padding(horizontal = 30.dp), onClick = {})
    }
//        QuitButton(onClick = {})
}


// 정보 입력 화면 2
@Composable
fun DataInputScreen2(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTitleText(
            modifier = Modifier.padding(top = 40.dp),
            text = "자신의 정보를 입력해주세요.",
        )
        Column(
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(
                10.dp, alignment = Alignment.CenterVertically
            )
        ) {
            DataInputCard(dataName = "지원 직무", dataValue = "", onTextChanged = {})
            DataInputCard(dataName = "자격증 / 어학 / 수상내역", dataValue = "", onTextChanged = {})
            DataInputCard(dataName = "보유기술 및 능력", dataValue = "", onTextChanged = {})
        }
        NextButton(modifier = Modifier.padding(horizontal = 30.dp), onClick = {})
    }
//        QuitButton(onClick = {})
}

// 정보 입력 화면 3
@Composable
fun DataInputScreen3(
    modifier: Modifier = Modifier,
    resumeText: String,
    onTextChanged: (String) -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTitleText(
            modifier = Modifier.padding(top = 40.dp),
            text = "자신의 자기소개서를 입력해주세요.",
        )
        Column(
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(
                10.dp, alignment = Alignment.CenterVertically
            )
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(10.dp)),
                value = resumeText,
                onValueChange = { onTextChanged(it) },
                placeholder = {
                    Text(
                        text = "자기소개서: 600자 제한", color = Color.Gray.copy(.5f)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = BackgroundGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        NextButton(modifier = Modifier.padding(horizontal = 30.dp), onClick = {})
    }
//        QuitButton(onClick = {})
}

//===================================== 면접진행 중간 화면 ====================================


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlayPauseScreen(
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UsBlue.copy(.1f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))
        //  Surface(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {


            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "back",
                    modifier = Modifier
                        .alpha(.7f)
                        .padding(horizontal = 30.dp)
                )
            }
        }
        CustomTitleText(
            modifier = Modifier
                .fillMaxWidth()

                .padding(top = 90.dp, bottom = 160.dp),
            "수고하셨습니다.\n" + "조금만 더 힘내세요.\n" + "\n" + "다음으로는 \n" + "역량질문 2개가 제시됩니다.\n" + "\n" + "준비가 되셨디면 \n" + "버튼을 눌러주세요."
        )


        NextButton(modifier = Modifier.padding(horizontal = 30.dp), onClick = {})
    }


}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PlayPauseScreenPreview() {

    PlayPauseScreen()

}

//===================================== 정보 입력 후 성공 / 오류화면 ====================================


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InputAfterSuccessScreen(
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UsBlue.copy(.1f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))
        //  Surface(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {


            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "back",
                    modifier = Modifier
                        .alpha(.7f)
                        .padding(horizontal = 30.dp)
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center
        ) {


        }
        CustomTitleText(
            modifier = Modifier
                .padding(top = 40.dp, bottom = 10.dp)
                .fillMaxWidth(), "정보 입력 완료 !"
        )

        Image(
            painter = painterResource(id = R.drawable.ic_input_after_success),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .padding(horizontal = 50.dp, vertical = 40.dp)
        )

        Text(
            text = "수고하셨습니다!",
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            color = Color.DarkGray.copy(.8f)
        )

        CustomTitleText(
            modifier = Modifier
                .fillMaxWidth()

                .padding(10.dp), "정보 입력이 정상적으로\n완료되었습니다."
        )

        Image(painter = painterResource(id = R.drawable.ic_input_after_start_play_button),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 0.dp)
                .clickable { })


    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InputAfterFailScreen(
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(UsBlue.copy(.1f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 17.dp))
        //  Surface(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {


            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "back",
                    modifier = Modifier
                        .alpha(.7f)
                        .padding(horizontal = 30.dp)
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "정보 입력 오류 !",
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.DarkGray.copy(.8f)
            )


            Image(
                painter = painterResource(id = R.drawable.ic_input_after_fail),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(140.dp)
                    .padding(horizontal = 50.dp, vertical = 40.dp)
            )


            Text(
                text = "오류가 발생하였습니다.",
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                color = Color.DarkGray.copy(.8f)
            )
            Text(
                text = "정보 입력이 정상적으로 \n" + "완료되지 않았습니다.",
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 60.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.DarkGray.copy(.8f)
            )

            Image(painter = painterResource(id = R.drawable.ic_input_after_back_button),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 0.dp)
                    .clickable { })


        }
    }

}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun InputAfterSuccessScreenPreview() {

    InputAfterSuccessScreen()

}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun InputAfterFailScreenPreview() {

    InputAfterFailScreen()

}


//===================================== 면접진행 후 피드백 화면 ====================================
/////상진님 이게 맞나요,,여기가 맞나요,,? ㅜ ㅜ ㅜ
@Composable
fun PlayAfterDetailCard(
    modifier: Modifier = Modifier, DetailTitle: String, DetailContent: String
) {

    var isExpanded by remember { mutableStateOf(false) }


    val extraPadding by animateDpAsState(
        if (isExpanded) 48.dp else 0.dp, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )

    Box(
        modifier = modifier
            //.background(UsBlue.copy(alpha = 0.05f))
            .border(1.dp, (UsBlue.copy(alpha = 0.5f)), RoundedCornerShape(10.dp))
            .clickable { isExpanded = !isExpanded },

        ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            // Row() {


            Text(
                text = DetailTitle,
                modifier = Modifier.padding(top = 10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
                color = Color.DarkGray.copy(.8f)
            )


            IconButton(
                onClick = { isExpanded = !isExpanded },

                ) {
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "Show",
                    modifier = Modifier
                        .alpha(.7f)
                        .fillMaxWidth()

                )


                // Text(if (isExpanded) "Show more" else "Show less")
                //  }

            }
            if (isExpanded) Text(
                text = DetailContent,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Left,
                fontSize = 11.sp,
                color = Color.Gray,

                //maxLines = if (isExpanded) Int.MAX_VALUE else 3,


            )
            else " "


        }
    }
}


@Composable
fun PlayAfterDetailCardGrid(
    modifier: Modifier = Modifier
) {
    CustomTitleText(Modifier.padding(top = 20.dp, bottom = 30.dp), "✓ 230406 면접의 질문 피드백")
    LazyVerticalGrid(contentPadding = PaddingValues(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        // 그리드 각 항목들이 사이즈 비율이 안 맞았던 이유
        // -> LazyHorizontalGrid 높이에 고정 값 주려면 패딩 값이나 space 값 도 계산 해서 해줘야…
        modifier = modifier.height(480.dp),
        columns = GridCells.Fixed(1),
        content = {
            items(DetailContentData.size) { index ->
                PlayAfterDetailCard(
                    modifier = Modifier,
                    DetailTitle = DetailTitleData[index],
                    DetailContent = DetailContentData[index]

                )

            }
        })
}


@Composable
fun PlayAfterFeedbackScreen(
    modifier: Modifier = Modifier,
) {
    //val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .background(UsBlue.copy(.2f))
            .fillMaxSize()
        //.height(240.dp)

    ) {
        //MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 25.dp))


        IconButton(onClick = { }) {
            Icon(
                Icons.Filled.Home, "back", modifier = Modifier
                    .alpha(.7f)
                    // .size(20.dp)
                    .padding(vertical = 20.dp, horizontal = 20.dp)

            )
        }


        Text(
            text = "면접이 종료되었습니다!\n" + "\n" + "수고하셨습니다",
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 60.dp),
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal,
            fontSize = 25.sp,
            fontWeight = FontWeight.W800,
            color = UsBlue
        )



        Divider(color = Color.Gray, thickness = 1.dp)



        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {

            CustomTitleText(Modifier.padding(top = 50.dp), "✓ 230406 면접의 총평 피드백")





            Surface(
                modifier = Modifier.padding(vertical = 30.dp, horizontal = 30.dp)

            ) {


                Text(
                    text = stringResource(id = R.string.PlayAfterFeedbackTotalFeedbackData),
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            UsBlue.copy(alpha = .5f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(30.dp),

                    textAlign = TextAlign.Left,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }


            //ScrollableColumn()
            //PlayAfterFeedbackMainFeedbackCardGrid()
            PlayAfterDetailCardGrid(modifier = Modifier.padding(bottom = 30.dp))

        }
    }

}


@Preview
@Composable
fun PlayAfterFeedbackApp() {
    MaterialTheme {
        Scaffold(
            // bottomBar = { BottomNavigation() }
        ) { padding ->
            PlayAfterFeedbackScreen(
                Modifier.padding(padding)
            )
        }
    }

}


///////////////

@Composable
fun HomeFeedbackCard(
    modifier: Modifier = Modifier, DetailTitle: String, DetailContent: String
) {

    var isExpanded by remember { mutableStateOf(false) }


    val extraPadding by animateDpAsState(
        if (isExpanded) 48.dp else 0.dp, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )

    Box(
        modifier = modifier
            //.background(UsBlue.copy(alpha = 0.05f))
            .border(1.dp, (UsBlue.copy(alpha = 0.5f)), RoundedCornerShape(10.dp))
            .clickable { isExpanded = !isExpanded },

        ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            // Row() {


            Text(
                text = DetailTitle,
                modifier = Modifier.padding(top = 10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
                color = Color.DarkGray.copy(.8f)
            )


            IconButton(
                onClick = { isExpanded = !isExpanded },

                ) {
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "Show",
                    modifier = Modifier
                        .alpha(.7f)
                        .fillMaxWidth()

                )


                // Text(if (isExpanded) "Show more" else "Show less")
                //  }

            }
            if (isExpanded) Text(
                text = DetailContent,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Left,
                fontSize = 11.sp,
                color = Color.Gray,

                //maxLines = if (isExpanded) Int.MAX_VALUE else 3,


            )
            else ""


        }
    }
}


@Composable
fun HomeFeedbackCardGrid(
    modifier: Modifier = Modifier
) {
    CustomTitleText(Modifier.padding(vertical = 30.dp), "230406 면접의 질문 피드백")
    LazyVerticalGrid(contentPadding = PaddingValues(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        // 그리드 각 항목들이 사이즈 비율이 안 맞았던 이유
        // -> LazyHorizontalGrid 높이에 고정 값 주려면 패딩 값이나 space 값 도 계산 해서 해줘야…
        modifier = modifier.height(480.dp),
        columns = GridCells.Fixed(1),
        content = {
            items(DetailContentData.size) { index ->
                HomeFeedbackCard(
                    modifier = Modifier,
                    DetailTitle = DetailTitleData[index],
                    DetailContent = DetailContentData[index]

                )

            }
        })
}


@Composable
fun HomeFeedbackScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.fillMaxSize()

    ) {
        MainTopBar(Modifier.padding(horizontal = 17.dp, vertical = 25.dp))







        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {

            CustomTitleText(Modifier.padding(top = 40.dp), "230406 면접의 총평 피드백")





            Surface(
                modifier = Modifier.padding(vertical = 40.dp, horizontal = 30.dp)

            ) {


                Text(
                    text = stringResource(id = R.string.PlayAfterFeedbackTotalFeedbackData),
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            UsBlue.copy(alpha = .5f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(30.dp),

                    textAlign = TextAlign.Left,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }


            //ScrollableColumn()
            //PlayAfterFeedbackMainFeedbackCardGrid()
            PlayAfterDetailCardGrid(modifier = Modifier.padding(bottom = 30.dp))

        }
    }

}

///////////////
//url_video_play
@SuppressLint("RememberReturnType", "UnsafeOptInUsageError")
@Composable
fun PlayVideo(context: Context) {

    val videoUrl =
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    // val videoUrl= "file://Users/mj/Desktop/Video/시작영상3.mp4"

    val exoPlayer = remember(context) {
        SimpleExoPlayer.Builder(context).build().apply {
            val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
                context, getUserAgent(context, context.packageName)
            )

            val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(videoUrl))

            this.prepare(source)


            //playbackParameters.setSpeed(2.0f);
            val playbackParameters = PlaybackParameters(0.5f)

            this.setPlaybackParameters(playbackParameters)
            this.playWhenReady = true
            //종료 this.pause()
            //시작 this.play()

        }


    }

    AndroidView(factory = { context ->
        PlayerView(context).apply {
            useController = false
            player = exoPlayer
        }


    })


}


///mp4_file_player
@SuppressLint("RememberReturnType", "UnsafeOptInUsageError")
@Composable
fun PlayVideoScreen(context: Context, videoPath: String) {

    val exoPlayer = remember(context) {
        SimpleExoPlayer.Builder(context).build().apply {
            val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
                context, getUserAgent(context, context.packageName)
            )

            val mediaItem = MediaItem.fromUri(videoPath)
            this.setMediaItem(mediaItem)

            this.prepare()
            this.play()
        }
    }

    AndroidView(factory = { context ->
        PlayerView(context).apply {
            useController = true
            player = exoPlayer
        }
    })
}


@Preview
@Composable
fun ViewerScreenApp() {
    MaterialTheme {

    }

}


///////////////////////////////
@Preview
@Composable
fun HomeFeedbackApp() {
    MaterialTheme {
        Scaffold(
            // bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeFeedbackScreen(
                Modifier.padding(padding)
            )
        }
    }

}

//////////////////////////////////////
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DataInputPreview1() {

    DataInputScreen1()
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DataInputPreview2() {

    DataInputScreen2()
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DataInputPreview3() {

    DataInputScreen3(resumeText = "", onTextChanged = {})
}

private val DetailContentData = arrayOf(
    "수정된 답변: 팀 내 갈등이 생길 경우, 서로의 의견을 존중하고 가능한 한 객관적으로 문제를 분석하여 해결책을 찾으려고 노력합니다. 예를 들어, 각자의 의견을 자세히 들어보고 그 상대방이 왜 그런 의견을 가지는지 이해하려 노력합니다. 그리고 그 문제가 프로젝트에 어떤 영향을 미칠 수 있는지 고려하여, 최선의 해결책을 모색합니다. 만약 서로의 의견이 계속 충돌한다면, 중재자의 도움을 받는 것도 고려해보겠습니다.",
    "블록체인 기술과 암호화폐에 관심이 많았습니다. 여러 포럼 사이트에서 정보를 얻고, 거래소에서 거래를 자주 해보며 하나의 취미로 가지고 있었는 데...",

    " 4학년 2학기 때 학교수업을 병행하면서 인턴실습을 나가 실제로 기업에서의 백엔드 개발자에 대해 배웠습니다.기업에서 저는 백엔드에 관한 업무와 함께...",
    "저는 대학교 학부 웹 프로그래밍 수업을 통해 기본적인 HTML, CSS, Javascript를 통한 프론트엔드 프로젝트를 경험한 이후 웹에 대해 관심이 생겼습니다...",
    "블록체인 기술과 암호화폐에 관심이 많았습니다. 여러 포럼 사이트에서 정보를 얻고, 거래소에서 거래를 자주 해보며 하나의 취미로 가지고 있었는 데...",
)

private val DetailTitleData = arrayOf(
    "질문: \"어떻게 팀에서 갈등이 생길 경우 해결하나요?\"", "경험 질문",
    "직무 질문", "회사 질문",
    "기술 질문", "적성 질문",
    "기타 질문",


    )


private val PRContentData = arrayOf(
    "저는 대학교 학부 웹 프로그래밍 수업을 통해 기본적인 HTML, CSS, Javascript를 통한 프론트엔드 프로젝트를 경험한 이후 웹에 대해 관심이 생겼습니다...",
    "블록체인 기술과 암호화폐에 관심이 많았습니다. 여러 포럼 사이트에서 정보를 얻고, 거래소에서 거래를 자주 해보며 하나의 취미로 가지고 있었는 데...",
    " 4학년 2학기 때 학교수업을 병행하면서 인턴실습을 나가 실제로 기업에서의 백엔드 개발자에 대해 배웠습니다.기업에서 저는 백엔드에 관한 업무와 함께...",
)

private val PRTitleData = arrayOf(
    "자기소개 1",
    "자기소개 2",
    "자기소개 3",
)

private val alignDetailFeedbackData = arrayOf(
    "자기소개", "경험",
    "직무", "회사",
    "기술", "적성",

)

private val alignMainFeedbackData = arrayOf(
    "230313", "230413", "230513", "230613",
    "230313", "230413", "230513", "230613",
)

private val MainCardData = listOf(
    R.drawable.ic_main_card3,
    R.drawable.ic_main_card5,
    R.drawable.ic_main_card4,
    R.drawable.ic_main_card1,
    R.drawable.ic_main_card2,


    )


private val prepareImageData = listOf(
    R.drawable.ic_prepare1,
    R.drawable.ic_prepare2,
    R.drawable.ic_prepare3,
    R.drawable.ic_prepare3,


    )


private val prepareData = listOf(
    R.drawable.ic_prepare1 to R.string.Prepare_1,
    R.drawable.ic_prepare2 to R.string.Prepare_2,
    R.drawable.ic_prepare3 to R.string.Prepare_3,

    ).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int, @StringRes val text: Int
)

fun Modifier.clickableWithoutRipple(
    interactionSource: MutableInteractionSource, onClick: () -> Unit
) = composed(factory = {
    this.then(
        Modifier.clickable(interactionSource = interactionSource,
            indication = null,
            onClick = { onClick() })
    )
})


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

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PlaybuttonScreenPreview() {
    PlaybuttonScreen()
}


