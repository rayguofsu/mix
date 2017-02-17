//71. Simplify Path
//Total Accepted: 43400 Total Submissions: 206413 Difficulty: Medium
//
//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//
//click to show corner cases.
//Corner Cases:
//
//    Did you consider the case where path = "/../"?
//    In this case, you should return "/".
//    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//    In this case, you should ignore redundant slashes and return "/home/foo".


public String simplifyPath(String path) {
    if (path == null || path.length() == 0)
        return null;
    String[] parts = path.split("/");
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < parts.length; i++){
        if (parts[i].equals(".")||parts[i].equals("")) //taking care of /./ and // cases
            continue;
        else if (parts[i].equals("..")) { //taking care of /../ and /abc/../../ (both cases should be /)
            if (!stack.isEmpty())
                stack.pop();
           // else
           //     continue;
        } else
            stack.push(parts[i]);
    }
    if (stack.isEmpty())
        return "/";
    String result = ""; //how to initialized an result//guessing here can use null to init it as well; no: cannot use null to init, I think here
    while (!stack.isEmpty()) {
        result = "/" + stack.pop() + result;
    }
    return result;
}
