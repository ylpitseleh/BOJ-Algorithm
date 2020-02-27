/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_tetromino.cpp                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/02/26 11:07:51 by hmin              #+#    #+#             */
/*   Updated: 2020/02/27 11:40:45 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
0		ㅇㅁㅁㅁ

1		ㅇ
		ㅁ
		ㅁ
		ㅁ

2		ㅇㅁ
		ㅁㅁ

  3		    ㅇㅁㅁ
		ㅇ    ㅁ    ㅁ
4	5	ㅁㅁ      ㅇㅁ
		ㅁ    ㅁ    ㅁ
  6		    ㅇㅁㅁ

		ㅇ   ㅇㅁ
7	8	ㅁ     ㅁ
		ㅁㅁ   ㅁ

		ㅇㅁ   ㅁ
9	10	ㅁ     ㅁ
		ㅁ   ㅇㅁ

			ㅇㅁㅁ
11	12	ㅇ      ㅁ
		ㅁㅁㅁ

		ㅇㅁㅁ
13	14	ㅁ      ㅁ
			ㅇㅁㅁ

15	16	ㅇㅁ      ㅁㅁ
		  ㅁㅁ  ㅇㅁ

		ㅇ      ㅁ
17	18	ㅁㅁ  ㅇㅁ
		  ㅁ  ㅁ
*/

// 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
//
// 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는
// 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로
// 주어지는 수는 1,000을 넘지 않는 자연수이다.
//
// 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

// 나중에 클래스 익숙해지면 재도전!
//
// class Block
// {
//   public:
// 	int type; // 0..18
// 	int x;	// coordinate on map
// 	int y;	// coordinate on map
// 	int width;
// 	int height;
//
// 	void initVars(int type)
// 	{
//
// 	}
// };

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int getMaxValue(vector<vector<int>> map, int type)
{
	vector<int> values;
	int value;

	int rL = map.size();
	int cL = map[0].size();
	for (int y = 0; y < rL; y++)
	{
		for (int x = 0; x < cL; x++)
		{
			// switch 문을
			// int getValue(vector<vector<int>> m, int type, int x, int y);
			// 위의 함수에 옮기고
			//
			// values.push_back(getValue(map, type, x, y));
			// 함수로 넘겼더니, 채점중이라고만 뜨고 시간이 뜨지 않았음.
			//
			//

			value = 0;

			switch (type)
			{
			case 0:
				if (x + 3 < cL)
					value = (map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y][x + 3]);
				break;
			case 1:
				if (y + 3 < rL)
					value = (map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 3][x]);
				break;
			case 2:
				if (x + 1 < cL && y + 1 < rL)
					value = (map[y][x] + map[y][x + 1] + map[y + 1][x] + map[y + 1][x + 1]);
				break;
			case 3:
				if (x + 2 < cL && y + 1 < rL)
					value = (map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);
				break;
			case 4:
				if (x + 1 < cL && y + 2 < rL)
					value = (map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x]);
				break;
			case 5:
				if (x + 1 < cL && y + 1 < rL && y - 1 >= 0)
					value = (map[y][x] + map[y - 1][x + 1] + map[y][x + 1] + map[y + 1][x + 1]);
				break;
			case 6:
				if (x + 2 < cL && y - 1 >= 0)
					value = (map[y][x] + map[y - 1][x + 1] + map[y][x + 1] + map[y][x + 2]);
				break;
			case 7:
				if (x + 1 < cL && y + 2 < rL)
					value = (map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 2][x + 1]);
				break;
			case 8:
				if (x + 1 < cL && y + 2 < rL)
					value = (map[y][x] + map[y][x + 1] + map[y + 1][x + 1] + map[y + 2][x + 1]);
				break;
			case 9:
				if (x + 1 < cL && y + 2 < rL)
					value = (map[y][x] + map[y][x + 1] + map[y + 1][x] + map[y + 2][x]);
				break;
			case 10:
				if (x + 1 < cL && y - 2 >= 0)
					value = (map[y][x] + map[y - 2][x + 1] + map[y - 1][x + 1] + map[y][x + 1]);
				break;
			case 11:
				if (x + 2 < cL && y + 1 < rL)
					value = (map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 1][x + 2]);
				break;
			case 12:
				if (x + 2 < cL && y + 1 < rL)
					value = (map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 2]);
				break;
			case 13:
				if (x + 2 < cL && y + 1 < rL)
					value = (map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x]);
				break;
			case 14:
				if (x + 2 < cL && y - 1 >= 0)
					value = (map[y][x] + map[y][x + 1] + map[y - 1][x + 2] + map[y][x + 2]);
				break;
			case 15:
				if (x + 2 < cL && y + 1 < rL)
					value = (map[y][x] + map[y][x + 1] + map[y + 1][x + 1] + map[y + 1][x + 2]);
				break;
			case 16:
				if (x + 2 < cL && y - 1 >= 0)
					value = (map[y][x] + map[y - 1][x + 1] + map[y][x + 1] + map[y - 1][x + 2]);
				break;
			case 17:
				if (x + 1 < cL && y + 2 < rL)
					value = (map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x + 1]);
				break;
			case 18:
				if (x + 1 < cL && y + 1 < rL && y - 1 >= 0)
					value = (map[y][x] + map[y + 1][x] + map[y - 1][x + 1] + map[y][x + 1]);
				break;
			}

			values.push_back(value);
		}
	}

	return *max_element(values.begin(), values.end());
}

int main(void)
{
	int rL, cL;

	cin >> rL;
	cin >> cL;

	vector<vector<int>> map(rL, vector<int>(cL));

	for (int i = 0; i < rL; i++)
		for (int j = 0; j < cL; j++)
			cin >> map[i][j];

	// 블록(0..18) 종류 별 최대값
	vector<int> maxValues(19, 0);

	for (int type = 0; type < 19; type++)
		maxValues[type] = getMaxValue(map, type);

	cout << *max_element(maxValues.begin(), maxValues.end());
	return (0);
}

// 4 5
// 1 2 3 4 5
// 1 2 3 4 6
// 1 2 3 4 7
// 1 2 3 4 8
//
// 26
