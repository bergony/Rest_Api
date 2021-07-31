package bergony.ml.rest_api.controllers;

//import bergony.ml.rest_api.model.client.Client;
//import bergony.ml.rest_api.services.feedService.FeedService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;


//public class FeedController {
//
//    public static final String BASE_URL = "/feed/";
//
//    private final FeedService feedService;
//
//    public FeedController(FeedService feedService) {
//        this.feedService = feedService;
//    }
//
//    @ApiOperation(value = "Seed a Question in the Feed ", notes = "Return void.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Suceess|OK"),
//            @ApiResponse(code = 401, message = "not authorized!"),
//            @ApiResponse(code = 403, message = "forbidden!!!"),
//            @ApiResponse(code = 404, message = "not found!!!") })
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public void SeedQuestionOnFeed(@RequestBody String question) {
//        feedService.SeedQuestionOnFeed(question);
//    }
//



//}
