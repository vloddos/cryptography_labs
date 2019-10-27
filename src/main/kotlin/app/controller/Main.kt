package app.controller

import rsa.RSA
import tornadofx.Controller
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.math.BigInteger

class Main : Controller() {

    private lateinit var rsa: RSA

    lateinit var publicKey: Pair<BigInteger, BigInteger>
    lateinit var privateKey: Pair<BigInteger, BigInteger>

    fun generate(numBits: Int, iterations: Int, algorithm: String) {
        rsa = RSA(numBits, iterations, algorithm)
        publicKey = rsa.publicKey
        privateKey = rsa.privateKey
    }

    fun encrypt(input: File, output: File) = rsa.encrypt(FileInputStream(input), FileOutputStream(output))
    fun decrypt(input: File, output: File) = rsa.decrypt(FileInputStream(input), FileOutputStream(output))
}
/*
rsa=RSA(
            BigInteger("950896196739321804398390663543428068743766200237407494169110536594207891711371353135927194722822372562786554884102415225778904738018216681996541783662557371853874317242861701296172753382626569881921077131065493135841503797545220411556609376355528829593202624697525760278852064419684409855695614405494027759168049780200222998653542987902581445815184775519755288025328465966065668924504406219265736370725928684490533069870945983713402453546188357513602925138831148946051281552593478433383866039211647011718826763753339638736645329748019273842256480481360875543543236749026470206684443032757258664742574164548605772552299396846306865211701466020513243299014580652362884820906948538956546011959967085366781930050449979562793463373211653469721293217501892232920333972764359665998119634239907149078078676619056092584055904805907839676242698845177772409081926773936436841833665166403677920944993607519581967274429523713729629958315561174994983853981862261303693179724014051137304956472167964040171305727009693680122853368051057475524033770652942026285621151586336812879210814513003980057854711366097111465182106136849949432891341944169237328322937589085063184418180326581182651589773560302423120858646114913140277600855956760639665933842684296048580042202540087964720185232689352750224536828869967889507798039152276758593179663821371422233800287498941602448945932795489690805288809618240556109578659153878455158298503746004999075572986395812731281564995547328012597036859002196613869586489917131645472629027180942611063111287468986701126547213160400696308169668153930380528810740651115680757061117981873988810936386736362288833318802390881627546138499974009869838296235197072480322762766469114477801798791917959793881391315163026660452241770150527296734727704741645837532120995466371977810053676689397748520155095532087937146701545297235861604697946447676366481985431697731187264714510443205763550530227836610180528891520115255166646458391554890630792176131156247666202964721120553487855382890936190028411549985486718987093245522556100722272186433358728081895204935929825735502018138890857297335249096518322217222360327857946498403234020810732070442877849589256305575701570944340932546910427237104951418310921911689765850269870936354647036309650469389118460327770390451316536393059426226873509040040788543559979097680185852000151585295940179044452371500275346027054232930834980908705153611293728527726736355635438248312979057734711041933316849759342392278102030318154201249"),
            BigInteger("2322908404405360545037496845995407334387788532136578417912171642187229325160846535632092054163530268579960463557385800573331968011849798720640072544301265412070169939517049005449390237076530282568863689986869276227818343090469094688395260310880655564613873679764250844823283401397592071998639433546811163996107519499890584807647751649903886405888449155222927608110524165235392550332483379290383939704675514328418458104334706055676215283415823867100491657316728371435941428782685348863656004309646192754663954162103952351674935384070934328712883417271467205005819779703199195471714981761304300225521366058854942307660783518895530994589912978245433031006919349983288121525020276473713562454219276338277622531584410074710723939534933185349971610069998824949404286933483307468891512894010782680479687312531445336194790753952485542620422492606367693930966936721249817365607632733972406855036390396981785148757150691930625824260797084571943276521078752462713685999870027588427281888292489142183513899604651227988806585603700183303376725268659035803667936406311107921667062461937791399632325125766977793899142476289007148045802983194090736264466170572198317682871514539641403994769313262093141304699904967934048921472348437197104561893865192537232975891881376255527910902533540466571913867811263724925930861062287471344564642500967379932171541865761011850417170268982064164646583785492892564990446846831746638312298042723494725810489190864040065836044766888692666733717991993855942721152211624189800835654013156670610177572170708114223785861350428968931729446813362702240495597267807860323058641006841916613315161210602071708489426058058675852441565613997993932858945271247388192877456468848458941984453828028169946399084039015138479540733953655240194784039391586442731851612022995389068676008519887611484489536483531014430903367849754473187018299101764815078575291413607716666270188180313547708455013016721425101037040056551030290763438908045386803650025565073535832994970971267899794172499026729645356805134949126479114461888986369868604767051330747155482471787430918418759746987194761584145405527903754358368692699281553178291871078481652527215670725559238641359346093889712105073679892631303626015153340647999113944429633016104924982440012016620596140333001878008484334291034290312516432436232302863590046973985904442582033741361507530839043478365821064299289132401455559957354927855147533962157387687541147582418560308346730293251477719712553788679802928031628082821"),
            BigInteger("11568743875057905426065696533594458139132870613301190175239127755492705079352091489572726341687662443259817434700384394618319114976209007907241961692224636994002761535641861497809054806247938910052172520997878687007380325068452273824741795386754409809388500504965732485296333031425273667266393499810098048897249125958265497608565153193653464762867972146391376989423055024607349212255107538522345501101640321462668362039178617226231904693809457790836616845761532120334634021121224425530978895064770409106162722040979326272562146639136053291920956286221951238630584663329656514742248580206282241393829689958125187518299109569300422628735281275458192128605710871336384461466655871992951678631944895000532731199220407247726721616511737890106865056227556602453205250436294542548845610859132658645947274570640274134268277810318204757118224285325833547233749382086640023347450425840459840890687168124919584780680027050033473388066447855762747894953924183799875147844563617454393585840098221900144431374336022471498711627940414539540415765622833864129698971966298652007519274778096820929824145737953674152891161478385821340353585688159713601755204789289462846213408371678381204019305293228271580738884706279154546963863831040312226028814236548164626412154983875274199763706811688675724776508713175766205987875198376116740233113876350845187663662221382661708716034555054744934864527768089261601216843857185628199505604462937058733515278132672625455892765411544549748264590702821251127651034929987342444867176837308212164478409391555099742578424463527365360324162322382633849775662396746737866911825407803932343236758112714429457029767131172257766570451347758522341212574901308907330963195846511992935182299076260652897693075151398291541940732915268193001588531576588945176833332807297625713014693873624559065546156801664524032884934983466123325712304373110992367462338594382424509836053873754541258245137718905756077716417244819189583437301142069673008163568355909559024261440090285812097358594730111052924063326159338105417087243088255045324801806534316901665885535317699788791880525400207957322662928942396166860611673970837748809577843603152127092501988016846039229842822368334364239044328212662951042693298521461276022466716252404942566064032295284466600673759604009008638254138973448631406712908867127484425792658604536026097016338283624642116398785115723080851499293647485309994181620764970008769400217701193959010051834350515993148325072162695905433041770986074019741")
        )
 */