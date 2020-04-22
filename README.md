### Update on 22/04
### README for Recommandation System

You need to install the Google plug-in before the browser can read the formula correctly
https://chrome.google.com/webstore/detail/mathjax-plugin-for-github/ioemnmodlmafdkllaclgeombjnmnbima/related?utm_source=chrome-ntp-icon

or

read 'TravelPlanner Recommandation System.html' and 'Travel Planner Data Processing.html'


## 1. Multi-dimensional rating system
In the travel planner project, we are tentatively using a multi-dimensional rating recommendation algorithm. On the one hand is the attribute rating of attractions and hotels themselves, on the other hand is a combination of user preferences rating.

The attribute ratings of attraction and hotels are divided into static attribute ratings and dynamic attribute ratings. Static rating refers to the fixed information of attractions and hotels; dynamic rating refers to the real-time information of attractions and hotels.


## 2. Attraction scoring
Attraction attribute scores are divided into static score, dynamic score and user-preference score, which mainly include the following three dimensions: 
* Static score - historical evaluation $s_j$ 
* Dynamic score - weather (not yet completed) $d_j$
* User-preference score - the types of attractions users prefer $u_j$.


### 2.1 Static historical evaluation.
I quantify the five evaluation latitudes (Terrible, Poor, Average, Very Good, Excellent) to 1.0-5.0, which means that the user's satisfaction is getting higher and higher. We can calculate the average score of the historical evaluation of all users as the target historical evaluation value. The higher the historical evaluation, the more worth recommending. Set the historical evaluation of the target as $<r_1,r_2,r_3,r_4,r_5>$, where ri represents the number of users rated as $r_i$ in the historical evaluation of the scenic spot, $i$ from 1 to 5. The formula for calculating the historical evaluation of the target is as follows:

$$
h_j = \frac{\sum_{i = 1}^5{ r_i}}{5 * \sum_{i = 1}^5{r_i}}
$$

Getting $h_j$ as the target's evaluation score, ranging from 0 to 1. (The denominator is a normalization term)

However, considering the number of comments will also affect the credibility of the score, we can use the number of comments as the weight of the evaluation score. If the number of reviews of hotels or attractions is more, the credibility of the ratings will be higher, so the weight of historical evaluation should be greater; otherwise, the smaller. The evaluation weights are calculated as follows:

$$
\alpha_j = \frac{c_j}{max(c_j)}
$$

Finally, the static review score can be calculated by:
$$ s_j = \alpha_j h_j $$


### 2.2 Dynamic weather score 
For each attraction, determine one or more types of weather that are most suitable for a certain type of attraction. The weather is divided into five categories: sunny, cloudy, windy, rainy, and snowy. When calculating the recommended score of scenic spots, the dynamic score calculation is performed according to the current weather status. When the current weather matches the most suitable weather of the scenic spot, the weather score is 1, otherwise it is 0.

For example, 
* $ W(Shopping mall)$ = [1 1 1 1 1] ,  because shoppingmall is basically suitable for all weather.

* While $ W(Gardens)$ = [1 0 0 0 1] ,  because natural scene generally has strict requirements on weather conditions.

$W(.)$ represents vectorizing function.

Dynamic Calculating,
$$
d_j =
\begin{cases}
0, & W_{real-time} \cdot W(type of attraction) \geq 1 \\[5ex]
1, & W_{real-time} \cdot W(type of attraction) = 0
\end{cases}
$$


### 2.3 User preference score 
Vectorize the types of attractions that the user is interested in and the types of all candidate attractions, and calculate the similarity between them. The higher the similarity, the more interested the user is and the more worth being recommended.

$$
u_j = \frac{TypAttr_j \cdot U_{prefer}}{n}
$$

$u_j$ represents the user's preference score of attraction $j$, range from 0 to 1.0;

$TypAttr_j$ represents vectorization of types of attractions $j$ ;

$U_{prefer}$ is vectorization of types of attractions user interests; 

$n$ is number of types of attraction user intests

For example, 
* user selects three labels($n = 3$): 'Concerts & Shows','Sights & Landmarks' and 'Historical sites' as his interests. Assume that only ten types of attractions are considered. $U_{prefer}$ = [1 0 0 1 0 1 0 0 0 0] 
* Tower of Bridge, the attraction $j$ will be high recommanded, because it has a great similarity with user preference. Tower of bridge has the labels: 'Sights & Landmarks', 'Points of Interest & Landmarks' and 'Historical sites'. $TypAttr_j$ = [1 1 0 1 0 0 0 0 0 0] 
* Therefore $ u_j = 2/3 \approx 0.667 $

### 2.4 Calculate attraction scores

$$
AttrScore_j = w_ss_j + w_dd_j + w_uu_j \\
w_s + w_u + w_d = 1
$$
$w$ is the weight of each scores and AttrScore is still from 0 to 1.0.

#### Assuming that the user visits 3 attractions a day and the travel period is 4 days, then the system will select the top 12 attractions with the highest ratings and call the clustering algorithm to divide them into 4 groups according to their location information. 



## 3. Hotel scoring
Hotel attribute ratings are also divided into static ratings and dynamic ratings, which mainly include the following three dimensions: hotel historical evaluation (static), price (dynamic), distance (dynamic, not yet completed), and the amenity property users need.

Hotel attribute scores are also divided into static score, dynamic score and user-preference score, which mainly include the following four dimensions: 
* Static score - historical evaluation $s_j$ 
* Dynamic score - price $dp_j$ and distance $dd_j$
* User-preference score - the amenity property users need $u_j$.

### 3.1 Static historical evaluation
Totally same as 2.1


### 3.2 Dynamic score 
### 3.2.1 price score 
Price is one of the important factors for users to choose hotels. The system can provide users with the ability to customize travel levels. For example, providing a one-to-five-star rating system for users to choose from, the higher the rating, the more the user is willing to spend; Or it provides the poor travel mode, ordinary mode and luxury mode. Different modes will assign different combination of weights to recommandation model. Price score is from 0 to 1.0

$$
dp_j = \frac{AvgP}{AvgP + P_j}
$$

where $AvgP$ is the average price of all hotels, $P_j$ is the price of hotel $j$

$$
AvgP = \frac{\sum_{j = 1}^m{P_j}}{m}
$$

where $m$ is the total number of candidate hotel

### 3.2.2 distance score 
The distance score is judged based on the average distance from the hotel to all selected attractions. The closer the distance, the lower the cost of transport, and the more worth recommending under the same circumstances.

To calculate the distance score, first put all the selected attractions in a set $A$, and calculate the distance between each attraction $a_k$ and each hotel candidate $h_j$ separately. The distance-based scoring formula is as follows, ranging from 0 to 1:

$$
dd_j = \frac{AvgD}{AvgD + D_j}
$$

where $AvgD$ is the average distance between all candidate hotel and all selected attractions, $D_j$ is the distance between hotel $j$ and all selected attractions $j$

$$
AvgD = \frac{\sum_{j = 1}^m{D_j}}{m}
$$

where $m$ is the total number of candidate hotel

### 3.3 User preference score 
Vectorize the amenity property of hotel that the user needs. Then, calculating the similarity between vectorized amenity of candidate hotels and vectorized user's requirement of amenity. The higher the similarity, the more worth being recommended. Ranging from 0 to 1.0;

$$
u_j = \frac{Amenity_j \cdot U_{need}}{p}
$$

$u_j$ represents the user's preference score of hotel $j$;

$Amenity_j$ represents vectorization of amenity of hotels $j$ ;

$U_{need}$ is vectorization of amenity property user needs; 

$p$ is number of amenity user needs

### 3.4 Calculate hotel scores

$$
HotelScore_j = w_ss_j + w_{dp}dp_j + w_{dd}dd_j + w_uu_j \\
w_s + w_u + w_{dp} + w_{dd} = 1
$$
$w$ is the weight of each scores and AttrScore is still from 0 to 1.0.

For example, 
* If user wishes to enjoy a luxury trip, which means they don't mind how much it will take. Therefore, the system will assign $w_{dp}$ to a lower value, while increase other weights. 

* If user do not express any perference or financial requirement on the hotel selection, we can use the default weights combination, which called 'Default Sorted'


##  4. Unfinshed module
### 4.1 stable data mining program (urgent)
For now, i am still using my own scraper to mine data from tripadvisor, but it is unstable due to the anti-scraper. <u>  so we still need someone to do some research on the tripadvisor api to get data on a stable method, which can guarantee the speed and efficiency.</u> 
    
What kind of info the system needs have shown in the 'Travel Planner.ipynb' and other csv file on the folder.
 
### 4.2 Distance module
Another problem we need to figure out is how to get the distance between each hotel or attraction. 
If we have the address(String), can we get the corresponding longtitude and latitude? Or directly get the distance or time spent?




____________________________________________________________________





### Update on 20/04
### README for TripAdivisor_Scraper
#### All scrapers can only be used for training data 

I have spent a lot of time to figure out the anti-scraper problem, but sometimes I still blocked by the tripadivisor sometimes. 

The Scrapers temporarily can be opened via Jupyter Notebook. If necessary, I will change to .py later

* TripAdvisor Hotel Scraper.ipynb

    * Confirm date and 'destination'
    * get hotel lists and scraper info and urls and stored as 'hotel_url_London.csv'
    * scrap all info we need via url and stored as 'hotel_info.csv'


* TripAdvisor flight Scraper.ipynb

    * Confirm date, departure and destination 
    * scrap all info we need and stored as'flight_info.csv'

* TripAdvisor Attraction.ipynb

    * Confirm destination 
    * get attraction lists and scraper info and urls and stored as 'attraction_url_London.csv'
    * scrap all info we need via url and stored as 'London_attraction.csv'
