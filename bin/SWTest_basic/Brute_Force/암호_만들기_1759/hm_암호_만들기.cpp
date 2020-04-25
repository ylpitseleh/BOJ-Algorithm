/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_암호_만들기.cpp                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/04/22 13:39:52 by hmin              #+#    #+#             */
/*   Updated: 2020/04/22 16:12:38 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
새로 배운 것

#include <vector>

int main()
{
    std::vector<bool> v(10);
    // using auto&& so that I can handle the rvalue reference
    //   returned for the vector<bool> case
    for (auto&& e : v)
        e = true;
}
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// const int MAX_PASSWORD_LEN = 15;
// const int MAX_CHAR_CNT = 15;

int password_len;
int char_cnt;

vector<char> password;
vector<char> chars;
vector<bool> is_used_char;
// chars는 sorting이 될 것이기에, index로 각 char별 사용 여부 판단 가능
// 전역변수는 0으로 초기화됨.

void dfs(int depth)
{
	// 암호 완성시 출력
	if (depth == password_len)
	{
		// 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
		int vowel_cnt = 0;	   // 모음
		int consonant_cnt = 0; // 자음
		string result;

		for (auto &&ch : password)
		{
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				vowel_cnt++;
			else
				consonant_cnt++;
			result += ch;
		}

		if (vowel_cnt >= 1 && consonant_cnt >= 2)
			cout << result << "\n";

		return;
	}

	// i: 0 1 2 3 4 5
	// c: a b c d e f
	for (int i = 0; i < char_cnt; i++)
	{
		if (!is_used_char.at(i))
		{
			// 값이 오름차순 아니면 다음 순열로 넘어가기
			if (depth > 0 && chars.at(i) < password.at(depth - 1))
				continue;
			password.at(depth) = chars.at(i);
			is_used_char.at(i) = true;
			dfs(depth + 1);
			is_used_char.at(i) = false;
		}
	}
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> password_len >> char_cnt;
	// 4 6

	for (int i = 0; i < char_cnt; i++)
	{
		char ch;
		cin >> ch;
		chars.push_back(ch);
	}
	// a f c e d b

	sort(chars.begin(), chars.end());
	// a b c d e f

	password.assign(password_len, 0);
	is_used_char.assign(char_cnt, false);

	dfs(0);

	return (0);
}

/*
예제 입력 1
4 6
a t c i s w

예제 출력 1
acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
 */
