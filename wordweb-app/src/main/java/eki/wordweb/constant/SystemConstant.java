package eki.wordweb.constant;

public interface SystemConstant {

	String UTF_8 = "UTF-8";

	String DESTIN_LANG_ALL = "all";

	String DESTIN_LANG_EST = "est";

	String DESTIN_LANG_ENG = "eng";

	String DESTIN_LANG_RUS = "rus";

	String DESTIN_LANG_OTHER = "other";

	String[] SUPPORTED_DESTIN_LANGS = new String[] {DESTIN_LANG_EST, DESTIN_LANG_ENG, DESTIN_LANG_RUS};

	String[] SUPPORTED_DESTIN_LANG_FILTERS = new String[] {DESTIN_LANG_ALL, DESTIN_LANG_EST, DESTIN_LANG_ENG, DESTIN_LANG_RUS, DESTIN_LANG_OTHER};

	String DATASET_TYPE_LEX = "lex";

	String DATASET_TYPE_TERM = "term";

	String SEARCH_MODE_SIMPLE = "simple";

	String SEARCH_MODE_DETAIL = "detail";

	String GAME_DIFFICULTY_SIMPLE = "easy";

	String GAME_DIFFICULTY_HARD = "hard";

	long CACHE_EVICT_DELAY_5MIN = 5 * 60 * 1000;

	long CACHE_EVICT_DELAY_60MIN = 60 * 60 * 1000;

	String CACHE_KEY_NULL_WORD = "nullword";

	String CACHE_KEY_CLASSIF = "classif";

	String CACHE_KEY_CORPORA = "corpora";

	String UNKNOWN_FORM_CODE = "??";

	String[] ABBREVIATION_WORD_TYPE_CODES = new String[] {"l", "th"};

	String PREFIXOID_WORD_TYPE_CODE = "pf";

	String SUFFIXOID_WORD_TYPE_CODE = "sf";

	String FOREIGN_WORD_TYPE_CODE = "z";

	Float COLLOC_MEMBER_CONTEXT_WEIGHT = 0.5F;

	String DEFAULT_CLASSIF_VALUE_LANG = "est";

	String DEFAULT_CLASSIF_VALUE_TYPE = "wordweb";

	String CLASSIF_VALUE_TYPE_ISO2 = "iso2";

	String WORD_SEARCH_GROUP_WORD = "word";

	String WORD_SEARCH_GROUP_AS_WORD = "as_word";

	String WORD_SEARCH_GROUP_FORM = "form";
}
