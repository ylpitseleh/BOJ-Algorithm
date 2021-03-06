/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_1,2,3_더하기.cpp                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/08 21:46:33 by hmin              #+#    #+#             */
/*   Updated: 2020/03/09 01:55:45 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
그냥 나 혼자 문제를 풀려고 했더니, 엄청 비효율적인 dfs 방식으로 문제를 어렵게
풀어나가고 있었다.

심지어 문제조차 제대로 이해 못 했으니 당연히 패턴 파악에도 실패...

"합을 나타낼 때는 수를 1개 이상 사용해야 한다." 라는 말이
"수 1개 만으로도 합을 나타낼 수 있다." 라는 말일 줄은... Joder.

ex)
3 (4개)

1+1+1
1+2
2+1
[[[★ 3 ★]]]

역시 어느 정도 고민해보고 도저히 답이 없으면 그냥 고수의 답을 보고 내 걸로 만드는 게 훨씬 현명하다.

참고: https://wootool.tistory.com/77

근데 등차 계차까진 생각 해봤는데 점화식은 생각을 못 했네... 쩝
 */

#include <iostream>
using namespace std;

const int MAX_NUM = 11;

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int case_cnt;
	cin >> case_cnt;

	int ans[MAX_NUM] = {
		1,
	};

	// ans[N] = ans[N-1] + ans[N-2] + ans[N-3]
	// 위의 점화식으로 ans 값 미리 할당
	for (int i = 1; i <= MAX_NUM; i++)
	{
		if (i - 1 >= 0)
			ans[i] += ans[i - 1];
		if (i - 2 >= 0)
			ans[i] += ans[i - 2];
		if (i - 3 >= 0)
			ans[i] += ans[i - 3];
	}

	for (int i = 0; i < case_cnt; i++)
	{
		int num;
		cin >> num;
		cout << ans[num] << "\n";
	}

	return (0);
}

/*
3
4
7
10

7
44
274

********************************************************************************
1 (1)
1

2 (2)
1+1
2

3 (4)
1+1+1
1+2
2+1
3

4 (7)
1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1

5 (13)
1+1+1+1+1 (1)
1+1+1+2 (4)
1+2+2 (3)
1+1+3 (3)
2+3 (2)

(0: 1)
1: 1
2: 2
3: 4
4: 7 (1+2+4)
5: 13 (2+4+7)
6: 24 (4+7+13)
7: 44 (7+13+24)
...
10 :274

Arr[N] = Arr[N-1] + Arr[N-2] + Arr[N-3]
 */
